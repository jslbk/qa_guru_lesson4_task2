import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropOptionalTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    }

    @Test
    @Description("Uses Selenium's drag and drop method to switch squares and checks they switched")
    void dragAndDropActionTest() {
        $("h3").shouldBe(visible).shouldHave(text("Drag and Drop"));
        $("#columns").$("div header").shouldHave(text("A"));
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#columns").$("div header").shouldHave(text("B"));
    }

    @Test
    @Description("Uses Selenide's drag and drop method to switch squares and checks they switched")
    void dragAndDropViaSelenideTest() {
        $("h3").shouldBe(visible).shouldHave(text("Drag and Drop"));
        $("#columns").$("div header").shouldHave(text("A"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#columns").$("div header").shouldHave(text("B"));
    }

}