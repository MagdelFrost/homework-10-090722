package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIssueOriginTests {

    String SEARCH = "selenide/selenide";
    int NUM = 1946;

    @Test
    public void IssueOriginTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(SEARCH);
        $(".header-search-input").submit();

        $(By.linkText(SEARCH)).click();

        $("#issues-tab").click();

        $(withText("#" + NUM)).should(Condition.exist);
    }
}
