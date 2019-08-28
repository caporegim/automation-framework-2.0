import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.uitests.config.Config;
import io.github.uitests.config.ModuleConfig;
import org.assertj.core.api.Assertions;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

@FluentConfiguration(webDriver = "firefox")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
public class FirefoxTest extends FluentTest {
    @Autowired
    private ModuleConfig moduleConfig;

    static {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setUp() {
        final List<String> versions = WebDriverManager.firefoxdriver().getVersions();
        System.out.println("versions" + versions);
        WebDriverManager.firefoxdriver()
                .proxy("127.0.0.1:9443")
                .forceDownload()
                .proxyUser(moduleConfig.getProxyUsername())
                .proxyPass(moduleConfig.getProxyPassword())
                .setup();
    }

    @Test
    void test() {

        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        Assertions.assertThat(window().title()).contains("FluentLenium");
    }

    @Test
    void test2() {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.google.com/");
//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("mysql excel 2013");
//        element.submit();
    }
}
