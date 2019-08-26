package io.github.uitests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${user.dir}/module.properties")
public class Credentials {
    @Value("${appUsername}")
    private String appUsername;
    @Value("${appPassword}")
    private String appPassword;
    @Value("${appStationId}")
    private String appStationId;
    @Value("${appRole}")
    private String appRole;


    public String getAppUsername() {
        return appUsername;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public String getAppStationId() {
        return appStationId;
    }

    public String getAppRole() {
        return appRole;
    }
}
