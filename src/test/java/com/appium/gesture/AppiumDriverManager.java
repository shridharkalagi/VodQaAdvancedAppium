package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shridhk on 2/2/18.
 */
public class AppiumDriverManager {

    private static AppiumDriverManager appiumDriverManager;

    private AppiumDriver appiumDriver;

    private AppiumDriverManager() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "aa");
        try {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    //private static AppiumDriverManager driverInstance;

    public static AppiumDriverManager getAppiumDriverManager() {

        if (null == appiumDriverManager) {

            appiumDriverManager = new AppiumDriverManager();

        }
        return appiumDriverManager;

    }


    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }
}
