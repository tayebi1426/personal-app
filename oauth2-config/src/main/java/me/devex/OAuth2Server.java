package me.devex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.devex.config")
public class OAuth2Server {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Server.class, args);
    }

}

