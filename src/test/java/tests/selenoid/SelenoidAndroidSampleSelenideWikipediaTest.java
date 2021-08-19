package tests.selenoid;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.browserStack.BrowserStackTestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SelenoidAndroidSampleSelenideWikipediaTest extends BrowserStackTestBase {

    @Test
    @Owner("iignatov")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("UI")
    @Tag("android")
    @Feature("Search item")
    @Story("Successful search")
    @DisplayName("Check result of successful search")
    void searchSampleTestWithSelenide() {

        step("Input string for search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
        });

        step("Check the result of search", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });

    }

    @Test
    @Owner("iignatov")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("UI")
    @Tag("android")
    @Feature("Settings menu section")
    @Story("Successful open the Settings menu section")
    @DisplayName("Check successful open of Settings menu section")
    void openSettingMenuWithSelenide() {

        step("Go to Settings menu section", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });

        step("Check opened Settings menu section", () -> {
            $(MobileBy.id("android:id/title")).shouldHave(Condition.text("Wikipedia language"));
        });

    }
}



/*
com.android.chrome:id/search_box_text
	android:id/title
		Wikipedia language
        Play Store
        com.facebook.katana:id/(name removed)   	FORGOT PASSWORD?   	android.widget.TextView
        com.android.packageinstaller:id/permission_allow_button    	Allow  	android.widget.Button
        com.android.packageinstaller:id/permission_allow_button
        com.facebook.katana:id/(name removed)  	Find Your Account android.widget.TextView


        org.wikipedia.alpha:id/menu_overflow_button
        org.wikipedia.alpha:id/explore_overflow_settings
        General
        android.widget.TextView*/
