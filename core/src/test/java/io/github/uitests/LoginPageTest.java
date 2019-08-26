package io.github.uitests;

import io.github.uitests.config.Credentials;
import io.github.uitests.page.LoginPage;
import io.github.uitests.page.WorkQueuePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageTest extends BaseTest {

    @Autowired
    private Credentials credentials;

    @Page
    private LoginPage loginPage;

    @Page
    private WorkQueuePage workQueuePage;

    @Test
    void testLogin() {
        getDriver().manage().window().maximize();
        goTo(loginPage).loginWith(credentials);
        workQueuePage.isAt();

    }
}