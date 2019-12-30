package me.dev.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties
@Validated
public class OAuthServerProps {

    @Max(5)
    @Min(0)
    private int threadPool;

    @NotEmpty
    private String email;
}
