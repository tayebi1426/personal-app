package me.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        return new JdbcUserDetailsService();
    }

    @Bean
    TokenEnhancer tokenEnhancer(UserDetailsService userDetailsService) {
        return new UserTokenEnhancer(userDetailsService);
    }
}