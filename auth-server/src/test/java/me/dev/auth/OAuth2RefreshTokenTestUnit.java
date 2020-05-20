package me.dev.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OAuth2RefreshTokenTestUnit {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void takeOAuth2RefreshToken() throws Exception {
        OAuth2AccessToken oAuth2AccessToken = takeAccessToken();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/token");
        requestBuilder.param("grant_type", "refresh_token")
                .param("refresh_token", oAuth2AccessToken.getRefreshToken().getValue())
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

    private OAuth2AccessToken takeAccessToken() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/token");
        requestBuilder.param("grant_type", "password")
                .param("username", "A$dmIn")
                .param("password", "1234")
                .header("Authorization", "Basic Y2xpZW50X2lkOmNsaWVudF9zZWNyZXQ=");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andReturn();
        return new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), OAuth2AccessToken.class);
    }
}
