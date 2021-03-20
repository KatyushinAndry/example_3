import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenidTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized=true;
    }

    @Test
    void githubSearchTest() {
        /* ----OpeningAndValidationPage */
        open("https://github.com/selenide/selenide");
        $(".HeaderMenu-summary").shouldHave(text("Why GitHub?"));
        //----
        $("[data-content='Wiki']").click();
        $(".markdown-body").$(byText("Soft assertions")).should(visible).click();
        //----assert
        $(".markdown-body").shouldHave(text("JUnit5")).should(visible);
    }

    @Test
    void dragDropTest() {
        /* ----OpeningAndValidationPage */
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));
        //----
        $("#column-a").dragAndDropTo($("#column-b"));

        // asserts
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
