package io.github.uitests;

import io.github.uitests.config.ModuleConfig;
import io.github.uitests.fluentlenium.CoreDefaultConfiguration;
import io.github.uitests.page.LoginPage;
import io.github.uitests.util.VeteranProvider;
import lombok.extern.slf4j.Slf4j;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FluentConfiguration(
        configurationDefaults = CoreDefaultConfiguration.class
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class AfterLoginBaseTest extends AbstractBaseTest {
    private boolean initialized;

    @Autowired
    protected ModuleConfig moduleConfig;

    @Qualifier("randomVeteranProvider")
    @Autowired
    protected VeteranProvider veteranProvider;

    @Page
    LoginPage loginPage;

    @BeforeEach
    void setUp() {
        if (!initialized) {
            beforeAll();
            initialized = true;
        }
    }

    private void beforeAll() {
        log.info("before method invoked in " + getClass());
        goTo(loginPage);
        await().untilPage().isLoaded();
        loginPage.loginWith(moduleConfig);
        before();
    }

    /**
     * Override this method before if need to do some work (go at some page etc.) before all tests in subclass.
     * It is workaround because junit-jupiter @BeforeAll does not work with fluentlenium @Page annotation.
     */
    protected void before() {
    }
}
