package io.github.uitests;

import io.github.uitests.config.Config;
import io.github.uitests.config.ModuleConfig;
import io.github.uitests.fluentlenium.CommonDefaultConfiguration;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
@FluentConfiguration(
        configurationDefaults = CommonDefaultConfiguration.class
)
public abstract class AbstractBaseTest extends FluentTest {

    @Autowired
    ModuleConfig moduleConfig;


}
