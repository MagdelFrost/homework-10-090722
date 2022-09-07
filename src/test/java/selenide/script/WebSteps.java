package selenide.script;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу GitHub")
    public void openMainPage() {

        open("https://github.com/");
    }

    @Step("Переходим на страницу репозитория")
    public void searchPage(String search) {

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(search);
        $(".header-search-input").submit();

        $(By.linkText(search)).click();
    }

    @Step("Переходим на вкладку Issue")
    public void openIssueTab() {

        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue")
    public void checkIssueNum(int num) {
        $(withText("#" + num)).should(Condition.exist);
    }
}
