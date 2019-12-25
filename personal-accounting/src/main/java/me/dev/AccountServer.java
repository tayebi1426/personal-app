package me.dev;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.dev.config")
public class AccountServer {

    public static void main(String[] args) {
        SpringApplication.run(AccountServer.class, args);
    }

}

