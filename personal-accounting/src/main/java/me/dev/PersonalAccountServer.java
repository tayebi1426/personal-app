package me.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc()
@SpringBootApplication(scanBasePackages = "me.dev")
public class PersonalAccountServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PersonalAccountServer.class, args);
    }

}

