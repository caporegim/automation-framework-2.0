package io.github.uitests.fluentlenium;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoreDefaultConfiguration extends CommonDefaultConfiguration {

    @Override
    public String getScreenshotPath() {
        return "/tmp/core-screenshots/" + LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + "/";
    }
}
