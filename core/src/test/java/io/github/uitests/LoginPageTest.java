package io.github.uitests;

import io.github.uitests.config.ModuleConfig;
import io.github.uitests.page.LoginPage;
import io.github.uitests.page.WorkQueuePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Login Test")
public class LoginPageTest extends AbstractBaseTest {

    @Autowired
    private ModuleConfig moduleConfig;

    @Page
    private LoginPage loginPage;

    @Page
    private WorkQueuePage workQueuePage;

    @Test
    void testLogin() {
        getDriver().manage().window().maximize();
        goTo(loginPage).loginWith(moduleConfig);
        workQueuePage.isAt();

    }
}
