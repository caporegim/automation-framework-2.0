package io.github.uitests.profile.veteran;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import io.github.uitests.common.Sex;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class VeteranProfileTest extends VeteranProfileBasePageTest {




    @Test
    void testUpdateName() {
        final String firstName = "abc";
        final String lastName = "def";
        veteranProfilePage.updateNameWith(firstName, lastName);
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);

        assertThat(veteranProfilePage.getFirstNameElement().text()).isEqualTo(firstName.toUpperCase());
        assertThat(veteranProfilePage.getLastNameElement().text()).isEqualTo(lastName.toUpperCase());
    }

    @Test
    void testUpdateSex() {
        final Sex sex = Sex.values()[new Random().nextInt(Sex.values().length)];
        veteranProfilePage.updateSexWith(sex);
        assertThat(veteranProfilePage.successMessage).hasText(THE_RECORD_WAS_UPDATED_SUCCESSFULLY);

        assertThat(veteranProfilePage.genderElement.text()).isEqualTo(StringUtils.capitalize(sex.name().toLowerCase()));
    }


}
