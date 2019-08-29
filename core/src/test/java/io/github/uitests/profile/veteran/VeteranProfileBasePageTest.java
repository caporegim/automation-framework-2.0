package io.github.uitests.profile.veteran;

import io.github.uitests.AfterLoginBaseTest;
import io.github.uitests.page.VeteranProfilePage;
import io.github.uitests.page.WorkQueuePage;
import org.fluentlenium.core.annotation.Page;

public class VeteranProfileBasePageTest extends AfterLoginBaseTest {
    @Page
    WorkQueuePage workQueuePage;
    @Page
    VeteranProfilePage veteranProfilePage;

    static final String THE_RECORD_WAS_UPDATED_SUCCESSFULLY = "The record was updated successfully";

    protected void before() {
        workQueuePage.searchVeteran(veteranProvider.provideVeteranFileNumber());
        await().untilPage(veteranProfilePage).isAt();
    }
}
