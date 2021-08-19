package tests.browserStack;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachAllure.*;
import static helpers.BrowserStack.getBSPublicLink;

public class BrowserStackTestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = BrowserStackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;

    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void stopDriverAndAddAttach() {


        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();

        closeWebDriver();

        attachAsText("Browserstack build link", getBSPublicLink(sessionId));

        attachVideo(sessionId); // in browserstack video url generates after driver close
    }
}
