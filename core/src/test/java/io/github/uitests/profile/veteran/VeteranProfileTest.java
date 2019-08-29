package io.github.uitests.profile.veteran;

import io.github.uitests.common.Sex;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class VeteranProfileTest extends VeteranProfileBasePageTest {

    @Test
    void testUpdateName() {
        final String originalFirstName = veteranProfilePage.getFirstNameElement().text();
        final String originalLastName = veteranProfilePage.getLastNameElement().text();
        final String firstName = "AUTOMATION";
        final String lastName = "TEST";
        veteranProfilePage.updateNameWith(firstName, lastName);
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);
        assertThat(veteranProfilePage.waitAndGetFirstNameText()).isEqualTo(firstName.toUpperCase());
        assertThat(veteranProfilePage.waitAndGetLastNameText()).isEqualTo(lastName.toUpperCase());

        veteranProfilePage.updateNameWith(originalFirstName, originalLastName);
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);
        assertThat(veteranProfilePage.waitAndGetFirstNameText()).isEqualTo(originalFirstName.toUpperCase());
        assertThat(veteranProfilePage.waitAndGetLastNameText()).isEqualTo(originalLastName.toUpperCase());
    }

    @Test
    void testUpdateSex() {
        final String originalSex = veteranProfilePage.waitAndGetSexText();
        final Sex sex = Sex.values()[new Random().nextInt(Sex.values().length)];
        veteranProfilePage.updateSexWith(sex);
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);
        assertThat(veteranProfilePage.waitAndGetSexText()).isEqualTo(StringUtils.capitalize(sex.name().toLowerCase()));

        veteranProfilePage.updateSexWith(Sex.valueOf(originalSex.toUpperCase()));
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);
        assertThat(veteranProfilePage.waitAndGetSexText()).isEqualTo(StringUtils.capitalize(originalSex));
    }


}
