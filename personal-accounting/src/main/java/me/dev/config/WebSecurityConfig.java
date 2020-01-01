package me.dev.config;

import me.dev.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;


@EnableResourceServer
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());

    }

    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore(accessTokenConverter());
    }
/*

    public JwkVerifyingJwtAccessTokenConverter jwkVerifyingJwtAccessTokenConverter(){
        JwkVerifyingJwtAccessTokenConverter converter=new  JwkVerifyingJwtAccessTokenConverter();
        return converter;
    }
*/

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public-key.pem");
        String publicKey = null;
        try {
            publicKey = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("publicKey : "+publicKey);
        tokenConverter.setVerifierKey(publicKey);
        return tokenConverter;
    }

    @Bean
    public AuditorAware auditorAware(){
        return new AuditorAware() {
            @Override
            public Optional getCurrentAuditor() {
                return Optional.empty();
            }
        };
    }

}
