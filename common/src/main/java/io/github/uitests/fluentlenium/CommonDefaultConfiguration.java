package io.github.uitests.fluentlenium;

import io.github.uitests.config.Config;
import io.github.uitests.config.ModuleConfig;
import org.fluentlenium.configuration.ConfigurationDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.github.uitests.config.ModuleConfig.*;

public class CommonDefaultConfiguration extends ConfigurationDefaults {
    private final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    private final ModuleConfig moduleConfigBean = applicationContext.getBean(ModuleConfig.class);

    @Override
    public String getBaseUrl() {
        return applicationContext.getBean(ModuleConfig.class).getEnvironment().getAppUrl(moduleConfigBean.getAppUrlSuffix());
    }

    @Override
    public String getWebDriver() {
        if (moduleConfigBean.isUseHttpProxy()) {
            return CustomChromeHttpProxyWebDriverFactory.CHROME_BEHIND_AWS_PROXY_FACTORY;
        } else {
            return super.getWebDriver();
        }
    }

    @Override
    public DriverLifecycle getDriverLifecycle() {
        return DriverLifecycle.CLASS;
    }

    @Override
    public TriggerMode getScreenshotMode() {
        return TriggerMode.AUTOMATIC_ON_FAIL;
    }

    @Override
    public String getScreenshotPath() {
        return "/tmp/screenshots/" + LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + "/";
    }

    @Override
    public String getCustomProperty(String propertyName) {

        switch (propertyName) {
            case PROXY_USERNAME:
                return moduleConfigBean.getProxyUsername();
            case PROXY_PASSWORD:
                return moduleConfigBean.getProxyPassword();
            case HOSTS_BEHIND_PROXY:
                return moduleConfigBean.getHostsBehindProxy();
            default:
                return super.getCustomProperty(propertyName);
        }

    }
}
