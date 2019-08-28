package io.github.uitests.fluentlenium;

import io.github.uitests.config.Credentials;
import io.github.uitests.util.ChromeBasicAuthHelper;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FactoryName;
import org.fluentlenium.configuration.WebDriverFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@FactoryName(CustomChromeHttpProxyWebDriverFactory.CHROME_BEHIND_AWS_PROXY_FACTORY)
public class CustomChromeHttpProxyWebDriverFactory implements WebDriverFactory {

    public static final String CHROME_BEHIND_AWS_PROXY_FACTORY = "chromeBehindAwsProxy";

    @Override
    public WebDriver newWebDriver(Capabilities desiredCapabilities, ConfigurationProperties configuration) {
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeBasicAuthHelper chromeBasicAuthHelper = new ChromeBasicAuthHelper();
        chromeOptions.addExtensions(chromeBasicAuthHelper.getExtensionFile());
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        ChromeBasicAuthHelper.AwsProperty awsProperty = new ChromeBasicAuthHelper.AwsProperty();
        awsProperty.setProxyUsername(configuration.getCustomProperty(Credentials.PROXY_USERNAME));
        awsProperty.setProxyPassword(configuration.getCustomProperty(Credentials.PROXY_PASSWORD));
        awsProperty.setHostsBehindProxy(configuration.getCustomProperty(Credentials.HOSTS_BEHIND_PROXY));

        chromeBasicAuthHelper.configureAuth(chromeDriver, awsProperty);
        return chromeDriver;
    }
}
