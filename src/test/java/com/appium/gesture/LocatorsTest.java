package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shridhk on 1/6/18.
 */
public class LocatorsTest {
    public AppiumDriver driver;

    @Test
    public void iOSCapsBasicWithTypeAndXpath() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/shridhk/Downloads/Vodqa.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(1000);

        driver.findElementByClassName("XCUIElementTypeTextField").clear();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("admin");
        driver.findElementByClassName("XCUIElementTypeSecureTextField").clear();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("admin");
        driver.findElementByXPath("//XCUIElementTypeOther[@name=\"login\"]").click();
        Thread.sleep(2000);
    }

    @Test
    public void iOSCapsBasicWithId() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/shridhk/Downloads/Vodqa.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("username").clear();
        driver.findElementByAccessibilityId("username").sendKeys("admin");
        driver.findElementByAccessibilityId("password").clear();
        driver.findElementByAccessibilityId("password").sendKeys("admin");
        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);
    }

    @Test
    public void iOSCapsFirstMatch() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/shridhk/Downloads/Vodqa.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("username").clear();
        driver.findElementByAccessibilityId("username").sendKeys("admin");
        driver.findElementByAccessibilityId("password").clear();
        driver.findElementByAccessibilityId("password").sendKeys("admin");
        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);
    }

    @Test
    public void iosPredicate() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/shridhk/Downloads/Vodqa.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        //Thread.sleep(1000);
        WebElement el = driver.findElementByAccessibilityId("login");
        new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        //driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);

        driver.findElement(MobileBy.iOSNsPredicateString("name BEGINSWITH 'Slide'")).click();
        Thread.sleep(1000);
        driver.findElementByXPath("//XCUIElementTypeOther[@name=\" Back\"]").click();
        Thread.sleep(1000);
        driver.findElement(MobileBy.iOSNsPredicateString("name ENDSWITH 'number'")).click();
        Thread.sleep(1000);
        driver.findElementByXPath("//XCUIElementTypeOther[@name=\" Back\"]").click();
        Thread.sleep(1000);
        driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS 'double tap'")).click();

    }

    @Test
    public void iosChaining() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/shridhk/Downloads/Vodqa.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("chainedView").click();

        String a = driver.findElement(MobileBy.AccessibilityId("container2")).findElement(MobileBy.AccessibilityId("textView")).getText();
        System.out.println("a: " + a);

//        driver.findElementByXPath("//XCUIElementTypeOther[@name=\" Back\"]").click();
//        Thread.sleep(1000);
//        driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS double tap")).click();

    }

    @Test
    public void androidCapsBasicWithTypeAndId() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shridhk/Downloads/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(1000);

        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("admin");
        driver.findElementByAccessibilityId("password").clear();
        driver.findElementByAccessibilityId("password").sendKeys("admin");
        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);
    }
}
