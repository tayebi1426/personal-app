package me.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountApiTestUnit {

    private static final String OAUTH_SRV_URL = "http://localhost:8001/oauth/token";
    private OAuth2AccessToken accessToken;

    @BeforeAll
    public void setup() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic Y2xpZW50X2lkOmNsaWVudF9zZWNyZXQ=");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request = new HttpEntity<>("grant_type=password&username=A$dmIn&password=1234", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OAuth2AccessToken> response = restTemplate.postForEntity(OAUTH_SRV_URL, request, OAuth2AccessToken.class);
        Assert.isTrue(HttpStatus.OK.equals(response.getStatusCode()), "http state is not Ok");
        Assert.notNull(response.getBody(), "http body is null");
        accessToken = new ObjectMapper().readValue(response.getBody().getValue(), OAuth2AccessToken.class);
    }

    @Test
    void name() {
        System.out.println(accessToken.getValue());
    }
}
