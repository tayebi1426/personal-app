package me.devex.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class JwsConfig {

    @Bean
    KeyPair keyPair() {
        ClassPathResource ksFile =
                new ClassPathResource("oauth2-server.jks");
        KeyStoreKeyFactory ksFactory =
                new KeyStoreKeyFactory(ksFile, "htb98980".toCharArray());
        return ksFactory.getKeyPair("oauth2-server-alias", "htb98980".toCharArray());
    }

    @Bean
    public JWKSet jwkSet(KeyPair keyPair) {
        RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID("oauth2-server-kid");
        return new JWKSet(builder.build());
    }
}
