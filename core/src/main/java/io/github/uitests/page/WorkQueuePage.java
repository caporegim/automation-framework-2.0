package io.github.uitests.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/workQueueInbox")
public class WorkQueuePage extends FluentPage {

    @FindBy(id = "toggleSearchBarButton")
    private FluentWebElement searchDropDown;

    @FindBy(id = "search-field")
    private FluentWebElement searchField;

    @FindBy(id = "vetProfileButton")
    private FluentWebElement openProfileButton;

    @FindBy(id = "intent_to_file")
    private FluentWebElement intentToFileLink;

    @FindBy(css = "html head title")
    private FluentWebElement pageTitle;


    public WorkQueuePage searchVeteran(final String fileNumber) {
        await().until(searchDropDown).displayed();
        searchDropDown.click();
        await().until(searchField).displayed();
        searchField.clear();
        searchField.fill().withText(fileNumber);
        openProfileButton.click();
        return this;
    }

    public void gotToIntentToFile() {
        intentToFileLink.click();
    }

}
