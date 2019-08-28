package io.github.uitests.config;

import io.github.uitests.common.Environment;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:${user.dir}/module.properties")
@Getter
public class ModuleConfig {
    public static final String PROXY_USERNAME = "proxyUsername";
    public static final String PROXY_PASSWORD = "proxyPassword";
    public static final String HOSTS_BEHIND_PROXY = "hostsBehindProxy";


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

    @Value("${environment}")
    private Environment environment;

    @Value("${appUrlSuffix}")
    private String appUrlSuffix;

}
