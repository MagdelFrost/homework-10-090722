package selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import selenide.script.WebSteps;

public class SelenideIssueStepTests {


    String SEARCH = "selenide/selenide";
    int NUM = 1946;

    @Test
    public void IssueOriginTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchPage(SEARCH);
        steps.openIssueTab();
        steps.checkIssueNum(NUM);
    }
}

