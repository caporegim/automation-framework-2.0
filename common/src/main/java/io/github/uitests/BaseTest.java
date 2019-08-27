package io.github.uitests;

import io.github.uitests.config.Config;
import io.github.uitests.config.Credentials;
import io.github.uitests.util.ChromeBasicAuthHelper;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
public abstract class BaseTest extends FluentTest {
    @Autowired
    Credentials credentials;

    @Override
    public WebDriver newWebDriver() {
        if (credentials.isUseHttpProxy()) {
            return createChromeWebDriverWithHttpProxy();
        } else {
            return super.newWebDriver();
        }
    }

    protected WebDriver createChromeWebDriverWithHttpProxy() {
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeBasicAuthHelper chromeBasicAuthHelper = new ChromeBasicAuthHelper();
        chromeOptions.addExtensions(chromeBasicAuthHelper.getExtensionFile());
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeBasicAuthHelper.configureAuth(chromeDriver, credentials);
        if (Boolean.TRUE.equals(getEventsEnabled())) {
            chromeDriver = new EventFiringWebDriver(chromeDriver);
        }
        return chromeDriver;
    }
}
