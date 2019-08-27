package io.github.uitests.util;

import io.github.uitests.config.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Helper to pass http proxy screen in chrome.
 * Solution based on https://stackoverflow.com/questions/44940815/how-to-set-proxy-authentication-in-seleniumwebdriver-for-chrome-browser/44950452#44950452
 *
 * @author petr.metin
 */
//@Component
public class ChromeBasicAuthHelper {
    private static final String CHROME_MULTI_PASS_FOR_HTTP_BASIC_AUTHENTICATION = "chrome/MultiPass-for-HTTP-basic-authentication_v0.8.4.crx";
    private static final String UTF_8 = "UTF-8";
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String EXTENSION_SETTINGS_PAGE = "chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html";

    private File extensionFile;

    public ChromeBasicAuthHelper() {
        log.debug("searching for resource: " + CHROME_MULTI_PASS_FOR_HTTP_BASIC_AUTHENTICATION);
        final URL resource = getClass().getClassLoader().getResource(CHROME_MULTI_PASS_FOR_HTTP_BASIC_AUTHENTICATION);
        try {
            //add URLDecoder.decode() to solve issues when path contains spaces
            final String filePath = resource != null ? URLDecoder.decode(resource.getFile(), UTF_8) : null;
            log.info("Using basic auth extension from : " + filePath);
            extensionFile = filePath != null ? new File(URLDecoder.decode(filePath, UTF_8)) : null;
        } catch (UnsupportedEncodingException e) {
            log.warn("Error during reading extension from path :" + resource.getFile(), e);
        }
    }

    /**
     * Setup url and credentials in extension.
     */
    public void configureAuth(WebDriver driver, Credentials credentials) {
        driver.get(EXTENSION_SETTINGS_PAGE);
        driver.findElement(By.id("url")).sendKeys(credentials.getHostsBehindProxy());
        driver.findElement(By.id("username")).sendKeys(credentials.getProxyUsername());
        driver.findElement(By.id("password")).sendKeys(credentials.getProxyPassword());
        driver.findElement(By.className("credential-form-submit")).click();
    }

    public File getExtensionFile() {
        return this.extensionFile;
    }
}
