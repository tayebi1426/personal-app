package me.dev.auth;

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

    private final static String ACCESS_TOKEN_PATH = "/oauth/token";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void invalidCredential() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(ACCESS_TOKEN_PATH);
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(ACCESS_TOKEN_PATH);
        requestBuilder.param("grant_type", "password")
                .param("username", "admin")
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


}
