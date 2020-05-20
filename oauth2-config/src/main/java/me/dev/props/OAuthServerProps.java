package me.dev.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@ConfigurationProperties(prefix = "oauth-srv")
@Validated
public class OAuthServerProps {


    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 30; // default 30 days.
    @Min(5)
    @Min(0)
    private int accessTokenValiditySeconds = 60 * 60 * 12; // default 12 hours.

    public int getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }
}
