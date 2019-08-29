package experiments;

import io.github.uitests.config.Config;
import io.github.uitests.util.VeteranProvider;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
@Tag("experimental")
public class SimpleDbTest {
    @Qualifier("randomVeteranProvider")
    @Autowired
    protected VeteranProvider veteranProvider;

    @Test
    void test() {
        System.out.println(veteranProvider.provideVeteranFileNumber());
    }
}
