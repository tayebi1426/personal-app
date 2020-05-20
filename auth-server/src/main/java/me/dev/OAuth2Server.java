package me.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "me.dev")
@ConfigurationPropertiesScan("me.dev.props")
@EnableWebMvc
public class OAuth2Server {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Server.class, args);
    }
}

