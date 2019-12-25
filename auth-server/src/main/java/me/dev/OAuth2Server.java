package me.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.dev.config")
public class OAuth2Server {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Server.class, args);
    }

}

