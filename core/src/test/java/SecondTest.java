import org.assertj.core.api.Assertions;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.Test;


public class SecondTest extends FluentTest {
    @Test
    void test() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        Assertions.assertThat(window().title()).contains("FluentLenium");

    }
}
