import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubSolutionsMenuTest {

    @Test
    void openEnterprisePageFromSolutionsMenuTest() throws InterruptedException {
        open("https://github.com/");
        $x("//button[contains(text(), 'Solutions')]").hover();
        $(".HeaderMenu-dropdown [href='/enterprise']").click();

        var expectedTitle = "The AI Powered Developer Platform. · GitHub";
        var wait = new WebDriverWait(driver().getWebDriver(), Duration.ofSeconds(5));

        // Wait until title is updated and check the title
        assertTrue(wait.until(ExpectedConditions.titleContains(expectedTitle)), "Title of the page should contain '" + expectedTitle + "'");
    }

}