package me.dev;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountApiTestUnit {

    @Autowired
    private MockMvc mockMvc;

    private static final String ACCESS_TOKEN_PATH = "http://127.0.0.1:8001/oauth/token";

    @BeforeAll
    public void setup() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(ACCESS_TOKEN_PATH);
        requestBuilder.param("grant_type", "password")
                .param("username", "A$dmIn")
                .param("password", "1234")
                .header("Authorization", "Basic Y2xpZW50X2lkOmNsaWVudF9zZWNyZXQ=");
        ResultActions resultActions = mockMvc.perform(requestBuilder);
                resultActions.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.ACCESS_TOKEN, Is.isA(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.REFRESH_TOKEN, Is.isA(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.TOKEN_TYPE, Is.is("bearer")))
                .andExpect(MockMvcResultMatchers.jsonPath(OAuth2AccessToken.EXPIRES_IN, Is.isA(Integer.class)));
        MvcResult mvcResult = resultActions.andReturn();
        MockHttpServletResponse resultResponse = mvcResult.getResponse();
        System.out.println(resultResponse);
        new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), OAuth2AccessToken.class);

    }

    @Test
    void name() {
        System.out.println("test");
    }
}
