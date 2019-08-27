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


    @Value("${useHttpProxy:false}")
    private boolean useHttpProxy;
    @Value("${hostsBehindProxy}")
    private String hostsBehindProxy;
    @Value("${proxyUsername}")
    private String proxyUsername;
    @Value("${proxyPassword}")
    private String proxyPassword;

    public boolean isUseHttpProxy() {
        return useHttpProxy;
    }

    public String getHostsBehindProxy() {
        return hostsBehindProxy;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

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
