package io.github.uitests;

import io.github.uitests.page.VeteranProfilePage;
import io.github.uitests.page.WorkQueuePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;

public class WorkQueuePageTest extends AfterLoginBaseTest {

    @Page
    WorkQueuePage workQueuePage;

    @Page
    VeteranProfilePage veteranProfilePage;


    @Test
    void testFindVeteran() {
        workQueuePage.isAt();
        workQueuePage.searchVeteran(veteranProvider.findVeteranFileNumber());
        await().untilPage(veteranProfilePage).isAt();
    }
}
