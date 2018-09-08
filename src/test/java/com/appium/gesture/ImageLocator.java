package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageLocator {

    private String APP_IOS = "https://github.com/cloudgrey-io/the-app/releases/download/v1.7.0/TheApp-v1.7.0.app.zip";
    private String APP_ANDROID = "https://github.com/cloudgrey-io/the-app/releases/download/v1.7.0/TheApp-v1.7.0.apk";

    private By loginScreen = MobileBy.AccessibilityId("Login Screen");
    private By username = MobileBy.AccessibilityId("username");
    private By password = MobileBy.AccessibilityId("password");
    private By loginBtn = MobileBy.AccessibilityId("loginBtn");
    private By verificationTextEspresso = By.xpath(
            "//com.facebook.react.views.text.ReactTextView[@text='You are logged in as alice']");
    private By verificationTextUiAuto2 = By.xpath(
            "//android.widget.TextView[contains(@text, 'alice')]");


    private static By photos = MobileBy.AccessibilityId("Photo Demo");

    @Test
    public void testImage_iOS() throws URISyntaxException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("appPackage","io.cloudgrey.the_app");
        capabilities.setCapability("appActivity","io.cloudgrey.the_app.MainActivity");
        capabilities.setCapability("app", APP_IOS);

        IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        actualTest(driver);
    }

    @Test
    public void testImage_Android() throws URISyntaxException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", APP_ANDROID);

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        actualTest(driver);
    }

    private String getReferenceImageB64() throws URISyntaxException, IOException {
        URL refImgUrl = getClass().getClassLoader().getResource("Edition031_Reference_Image.png");
        File refImgFile = Paths.get(refImgUrl.toURI()).toFile();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    public void actualTest(AppiumDriver driver) throws URISyntaxException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // get to the photo view
            wait.until(ExpectedConditions.presenceOfElementLocated(photos)).click();

            // wait for and click the correct image using a reference image template
            By sunriseImage = MobileBy.image(getReferenceImageB64());
            wait.until(ExpectedConditions.presenceOfElementLocated(sunriseImage)).click();

            // verify that the resulting alert proves we clicked the right image
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            Assert.assertTrue(alertText.contains("sunrise"));
        } finally {
            driver.quit();
        }
    }
}