package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shridhk on 12/28/17.
 */
public class SampleTest {
    public AppiumDriver driver;

    @Test
    public void basicAndroidCaps() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(10000);
        driver.quit();

    }

    //TODO - skip
    @Test
    public void AndroidCaps() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.vodqareactnative");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.vodqareactnative.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(10000);
    }

    @Test
    public void AndroidCapsNative() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(10000);
    }

    @Test
    public void iOSCapsBasic() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/VodQAReactNative.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "11.0");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.findElement(MobileBy.iOSNsPredicateString("name contains 'login'"));
        Thread.sleep(10000);
    }


    @Test
    public void AndroidCapsFullReset() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shridhk/Desktop/BuyNowMobile-VirginTrains.apk");
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void AndroidCapsNoReset() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shridhk/VodQaAdvancedAppium/VodQA.apk");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void AndroidCapsLocators() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shridhk/VodQaAdvancedAppium/VodQA.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);


        new WebDriverWait(driver, 30).until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("login")));

        driver.findElementByAccessibilityId("login").click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("chainedView")));

        driver.findElementByAccessibilityId("chainedView").click();
//
        String text = driver.findElementByAccessibilityId("container3").findElement(MobileBy.AccessibilityId("textView"))
                .getText();
        System.out.println(text);
        Thread.sleep(10000);
    }

    @AfterClass
    public void endSession() {
        //driver.quit();
    }

  /*
  adb logcat
  adb shell dumpsys window windows | grep -E 'mCurrentFocus|settings'
  ./aapt dump badging /Users/shridhk/AppiumTest/AndroidCalculator.apk
*/
}
