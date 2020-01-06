package me.dev.config;

import me.dev.dto.CustomUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomUserDetails principal = (CustomUserDetails) authentication.getUserAuthentication().getPrincipal();
        HashMap<String, Object> additionalInformation = new HashMap<>();
        additionalInformation.put("userId",principal.getId());
        DefaultOAuth2AccessToken oAuth2AccessToken=(DefaultOAuth2AccessToken) accessToken;
        oAuth2AccessToken.setAdditionalInformation(additionalInformation);
        return oAuth2AccessToken;
    }
}
