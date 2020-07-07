package me.dev;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@EnableWebMvc()
@SpringBootApplication(scanBasePackages = "me.dev")
public class PersonalAccountServer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PersonalAccountServer.class, args);
        //Main.main(args);
        //System.out.println(foldedLog());
    }
/*
    @Benchmark
    public static double foldedLog() {
        int x = 8;
        return Math.log(x);
    }*/
}

