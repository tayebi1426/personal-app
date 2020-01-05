package me.dev.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken oAuth2AccessToken=(DefaultOAuth2AccessToken) accessToken;
        oAuth2AccessToken.setAdditionalInformation(new HashMap<>());
        oAuth2AccessToken.getAdditionalInformation().put("email","tayebi1426@gmail.com");
        return oAuth2AccessToken;
    }
}
