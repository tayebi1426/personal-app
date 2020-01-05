package me.dev.config;

import me.dev.dto.CustomUserDetails;
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
        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        return new UsernamePasswordAuthenticationToken(new CustomUserDetails(1, "asdasd", "N/A", false, false, false), "N/A", authorities);
    }
}
