package com.testsPack;

import com.BaseTest;
import com.pagePack.PageOne;
import com.pagePack.SecondPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shridhk on 2/3/18.
 */
public class TestClassOne extends BaseTest {

    @Test
    public void AndroidCapsLocators() throws InterruptedException, MalformedURLException {

        new WebDriverWait(driver, 30).until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("login")));

        PageOne pageOne = new PageOne(driver);
        //pageOne.clickLogin().clickChaninedView();

        SecondPage secondPage = new SecondPage(driver);
        String s = secondPage.clickChaninedView();


//        driver.findElementByAccessibilityId("login").click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("chainedView")));

        driver.findElementByAccessibilityId("chainedView").click();
//
        String text = driver.findElementByAccessibilityId("container3").findElement(MobileBy.AccessibilityId("textView"))
                .getText();
        System.out.println(text);
        Thread.sleep(10000);
    }

}
