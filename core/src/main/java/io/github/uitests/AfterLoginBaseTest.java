package io.github.uitests;

import io.github.uitests.config.ModuleConfig;
import io.github.uitests.fluentlenium.CoreDefaultConfiguration;
import io.github.uitests.page.LoginPage;
import io.github.uitests.util.VeteranProvider;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FluentConfiguration(
        configurationDefaults = CoreDefaultConfiguration.class
)
public class AfterLoginBaseTest extends AbstractBaseTest {
    @Autowired
    protected ModuleConfig moduleConfig;

    @Qualifier("randomVeteranProvider")
    @Autowired
    protected VeteranProvider veteranProvider;

    @Page
    LoginPage loginPage;

    @BeforeEach
    protected void before() {
        goTo(loginPage);
        await().untilPage().isLoaded();
        loginPage.loginWith(moduleConfig);
    }
}
