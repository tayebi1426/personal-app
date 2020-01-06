package me.dev.config;

import me.dev.dto.CustomUserDetails;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put(USERNAME, userAuthentication.getName());
        Collection<? extends GrantedAuthority> authorities = userAuthentication.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authorities));
        }
        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        CustomUserDetails userDetails = new CustomUserDetails((Integer) map.get(CustomUserDetails.USER_ID),
                (String) map.get(CustomUserDetails.USERNAME));
        return new AbstractAuthenticationToken(Collections.emptyList()) {
            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return userDetails;
            }
        };
    }
}
