package tests.browserStack;

import config.App;
import config.Device;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrowserStackAndroidSampleTest {
    @Test
    void searchSampleTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", App.config.browserStackUsername());
        caps.setCapability("browserstack.key", App.config.browserStackPassword());

        // Set URL of the application under test
        caps.setCapability("app", App.config.app());

        // Specify device and os_version for testing
        caps.setCapability("device", Device.config.device());
        caps.setCapability("os_version", Device.config.os_version());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Selenide Appium Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "Search in Wikipedia test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL(App.config.browserStackURL()), caps);


        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Selenide");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName(
                "android.widget.TextView");
        assert (allProductsName.size() > 0);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }

}



