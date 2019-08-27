package io.github.uitests.page;

import io.github.uitests.common.Sex;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/veteranProfile")
public class VeteranProfilePage extends FluentPage {
    @FindBy(id = "identification-section-edit-btn")
    private FluentWebElement editIdentificationButton;

    @FindBy(id = "identificationSectionSaveBtn")
    private FluentWebElement saveIdentificationButton;

    @FindBy(id = "fNameInput")
    private FluentWebElement firstNameInput;

    @FindBy(id = "lNameInput")
    private FluentWebElement lastNameInput;

    @FindBy(id = "editIdentificationMessage-0")
    public FluentWebElement successMessage;

    @FindBy(id = "vetHeaderFName")
    private FluentWebElement firstNameElement;

    @FindBy(id = "vetHeaderLName")
    private FluentWebElement lastNameElement;

    @FindBy(id = "id-gender-birls-value")
    public FluentWebElement genderElement;

    @FindBy(id = "id-gender-male-save-value")
    private FluentWebElement genderMaleInput;

    @FindBy(id = "id-gender-female-save-value")
    private FluentWebElement gendeFemaleInput;

    @FindBy(id = "id-gender-undifferentiated-save-value")
    private FluentWebElement genderUndifferentiateIdnput;


    public VeteranProfilePage updateNameWith(String firstName, String lastName) {
        await().until(editIdentificationButton).displayed();
        editIdentificationButton.click();
        firstNameInput.fill().withText(firstName);
        lastNameInput.fill().withText(lastName);
        saveIdentificationButton.click();
        await().until(successMessage).displayed();
        return this;
    }

    public VeteranProfilePage updateSexWith(Sex sex) {
        await().until(editIdentificationButton).displayed();
        editIdentificationButton.click();

        switch (sex) {
            case MALE:
                genderMaleInput.click();
                break;
            case FEMALE:
                gendeFemaleInput.click();
                break;
            case UNDIFFERENTIATED:
            default:
                genderUndifferentiateIdnput.click();
        }
        saveIdentificationButton.click();
        await().until(successMessage).displayed();
        return this;

    }

    public FluentWebElement getFirstNameElement() {
        return firstNameElement;
    }

    public FluentWebElement getLastNameElement() {
        return lastNameElement;
    }
}
