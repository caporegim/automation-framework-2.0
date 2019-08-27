package io.github.uitests;

import io.github.uitests.config.Config;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
public abstract class BaseTest extends FluentTest {
}
