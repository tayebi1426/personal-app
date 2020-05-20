package me.dev.auth;

import net.minidev.json.JSONArray;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTokenEndpointTestUnit {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void failLogin() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/token");
        requestBuilder.param("grant_type", "password")
                .param("username", "nonce")
                .param("password", "123456789")
                .header("Authorization", "Basic Y2xpZW50X2lkOmNsaWVudF9zZWNyZXQ=");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error", Is.isA(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("error_description", Is.isA(String.class)));
    }

    @Test
    public void takeOAuth2AccessToken() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/token");
        requestBuilder.param("grant_type", "password")
                .param("username", "A$dmIn")
                .param("password", "1234")
                .header("Authorization", "Basic Y2xpZW50X2lkOmNsaWVudF9zZWNyZXQ=");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.ACCESS_TOKEN, Is.isA(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.REFRESH_TOKEN, Is.isA(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.TOKEN_TYPE, Is.is("bearer")))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.EXPIRES_IN, Is.isA(Integer.class)));
    }

    @Test
    public void getOAuthServerKid() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/.well-known/jwks.json");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.keys", Is.isA(JSONArray.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.keys[0].kid", Is.isA(String.class)));
    }

}
