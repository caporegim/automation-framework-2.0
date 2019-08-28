package io.github.uitests;

import io.github.uitests.config.ModuleConfig;
import io.github.uitests.util.SpringContext;
import org.junit.jupiter.api.Test;

public class NonSpringTest {
    @Test
    void name() {
        final ModuleConfig bean = SpringContext.getAppContext().getBean(ModuleConfig.class);
        System.out.println("stationId = " + bean.getAppStationId());
    }
}
