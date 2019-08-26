package io.github.uitests.page;


import io.github.uitests.config.Credentials;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

@PageUrl("/")
public class LoginPage extends FluentPage {

    @FindBy(id = "warning-modal-ok-btn")
    public FluentWebElement okButton;

    @FindBy(css = "div.panel-footer > a")
    private FluentWebElement loginUsingPassword;

    @FindBy(id = "stationIdPopUp")
    private FluentWebElement stationId;

    @FindBy(id = "usernamePopUp")
    private FluentWebElement usernamePopUp;

    @FindBy(id = "passwordPopUp")
    private FluentWebElement passwordPopUp;

    @FindBy(id = "profileIdPopUp")
    private FluentWebElement profileIdPopUp;

    @FindBy(xpath = "//*[@title='Login']")
    private FluentWebElement loginButton;


    public void loginWith(Credentials credentials) {
        await().until(okButton).displayed();

        okButton.getWrappedElement().sendKeys(Keys.SPACE);
        await().until(okButton).not().displayed();

        loginUsingPassword.click();
        await().until(() -> stationId.displayed() && stationId.clickable());
        stationId.fill().withText(credentials.getAppStationId());
        usernamePopUp.fill().withText(credentials.getAppUsername());
        passwordPopUp.fill().withText(credentials.getAppPassword());
        profileIdPopUp.fill().withText(credentials.getAppRole());
        await().until(() -> loginButton.displayed() && loginButton.clickable());

        loginButton.getWrappedElement().sendKeys(Keys.ENTER);
    }

}
