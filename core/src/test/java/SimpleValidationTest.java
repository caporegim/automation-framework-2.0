import io.github.uitests.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimpleValidationTest extends BaseTest {
    @Test
    void test() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        Assertions.assertThat(window().title()).contains("FluentLenium");

    }
}
