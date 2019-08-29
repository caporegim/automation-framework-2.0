package experiments;

import io.github.uitests.AbstractBaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("experimental")
public class SimpleValidationTest extends AbstractBaseTest {
    @Test
    void test() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        Assertions.assertThat(window().title()).contains("FluentLenium");

    }
}
