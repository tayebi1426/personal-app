package me.dev;


import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;

@EnableWebMvc()
@SpringBootApplication(scanBasePackages = "me.dev")
public class PersonalAccountServer {

    public static void main(String[] args) throws Exception {
        // SpringApplication.run(PersonalAccountServer.class, args);

        final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator(Duration.ofSeconds(90),6);
        final Key key;
        {
            final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());

            // SHA-1 and SHA-256 prefer 64-byte (512-bit) keys; SHA512 prefers 128-byte (1024-bit) keys
            keyGenerator.init(512);

            key = keyGenerator.generateKey();
        }
        final Instant now = Instant.now();
        final Instant later = now.plus(totp.getTimeStep());
        System.out.format("Current password : %06d\n", totp.generateOneTimePassword(key, now));
        System.out.format("Future password :  %06d\n", totp.generateOneTimePassword(key, later));


    }

}

