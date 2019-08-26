package io.github.uitests;

import io.github.uitests.config.Credentials;
import io.github.uitests.page.LoginPage;
import io.github.uitests.support.VeteranProvider;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class AfterLoginBaseTest extends BaseTest {
    @Autowired
    protected Credentials credentials;

    @Autowired
    protected VeteranProvider veteranProvider;

    @Page
    LoginPage loginPage;

    @BeforeEach
    protected void before() {
        goTo(loginPage);
        await().untilPage().isLoaded();
        loginPage.loginWith(credentials);
    }
}
