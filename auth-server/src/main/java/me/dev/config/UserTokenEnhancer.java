package me.dev.config;

import me.dev.dto.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Collections;

public class UserTokenEnhancer implements TokenEnhancer {

    private UserDetailsService userDetailsService;

    public UserTokenEnhancer(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        CustomUserDetails userDetails = getUserDetails(authentication);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(Collections.singletonMap("userId", userDetails.getId()));
        return accessToken;
    }

    private CustomUserDetails getUserDetails(OAuth2Authentication authentication) {
        Object principal = authentication.getUserAuthentication().getPrincipal();
        if (principal instanceof String) {
            return (CustomUserDetails) userDetailsService.loadUserByUsername((String) principal);
        } else if (principal instanceof CustomUserDetails) {
            return (CustomUserDetails) principal;
        } else {
            throw new IllegalStateException("Unsupported principal type");
        }
    }
}
