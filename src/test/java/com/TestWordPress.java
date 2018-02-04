package com;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shridhk on 2/3/18.
 */
public class TestWordPress {
    AppiumDriver driver;

    @Test
    public void SampleTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shridhk/VodQaAdvancedAppium/wordpress.apk");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.hideKeyboard();

        driver.findElementById("org.wordpress.android:id/nux_username").sendKeys("vodqa@gmail.com");


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/nux_sign_in_button")));
        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/password_layout")));
        driver.findElementById("org.wordpress.android:id/password_layout").click();


        driver.findElementById("org.wordpress.android:id/nux_password").sendKeys("Hello12345678");
        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/my_site_blog_posts_text_view")));
        driver.findElementById("org.wordpress.android:id/my_site_blog_posts_text_view").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/card_view")));

        String text = driver.findElementById("org.wordpress.android:id/text_title").getText();

        Assert.assertTrue(text.contains("VodQA"));
    }
}

