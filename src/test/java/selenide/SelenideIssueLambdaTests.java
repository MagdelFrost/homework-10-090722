package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideIssueLambdaTests {

    String SEARCH = "selenide/selenide";
    int NUM = 1946;

    @Test
    public void IssueLambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () -> {

            open("https://github.com/");
        });

        step("Переходим на страницу репозитория" + SEARCH,() -> {

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(SEARCH);
            $(".header-search-input").submit();
            $(By.linkText(SEARCH)).click();
        });

        step("Переходим на вкладку Issue", ()-> {

            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue №" + NUM, () -> {

            $(withText("#" + NUM)).should(Condition.exist);
        });
    }
}
