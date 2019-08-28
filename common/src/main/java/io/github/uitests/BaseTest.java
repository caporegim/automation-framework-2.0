package io.github.uitests;

import io.github.uitests.config.Config;
import io.github.uitests.config.ModuleConfig;
import io.github.uitests.fluentlenium.CustomChromeHttpProxyWebDriverFactory;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.CustomProperty;
import org.fluentlenium.configuration.FluentConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static io.github.uitests.config.ModuleConfig.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
@FluentConfiguration(webDriver = CustomChromeHttpProxyWebDriverFactory.CHROME_BEHIND_AWS_PROXY_FACTORY,
        custom = {
                @CustomProperty(name = PROXY_USERNAME, value = "egaito"),
                @CustomProperty(name = PROXY_PASSWORD, value = "P@ssw0rdP@ssw0rd"),
                @CustomProperty(name = HOSTS_BEHIND_PROXY, value = "va.gov")
        })
public abstract class BaseTest extends FluentTest {
/*    todo
        static {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }*/

    @Autowired
    ModuleConfig moduleConfig;

}
