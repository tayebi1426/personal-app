package me.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
public class AccessTokenConfiguration {

    @Bean
    public JwtTokenStore tokenStore() throws IOException {
        return new JwtTokenStore(accessTokenConverter());
    }

    /*    public JwkVerifyingJwtAccessTokenConverter jwkVerifyingJwtAccessTokenConverter(){
            JwkVerifyingJwtAccessTokenConverter converter=new  JwkVerifyingJwtAccessTokenConverter();
            return converter;
        }
    */

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setVerifierKey(readPublicKey());
        tokenConverter.setAccessTokenConverter(defaultAccessTokenConverter());
        return tokenConverter;
    }

    private String readPublicKey() throws IOException {
        Resource resource = new ClassPathResource("public-key.pem");
        String publicKey = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
        System.out.println("publicKey : " + publicKey);
        return publicKey;
    }

    @Bean
    public DefaultAccessTokenConverter defaultAccessTokenConverter() {
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        tokenConverter.setUserTokenConverter(userAuthenticationConverter());
        return tokenConverter;
    }

    @Bean
    public UserAuthenticationConverter userAuthenticationConverter() {
        return new CustomUserAuthenticationConverter();
    }
}