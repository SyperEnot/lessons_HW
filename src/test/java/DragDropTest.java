import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;
public class DragDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void moveDragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
//        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
