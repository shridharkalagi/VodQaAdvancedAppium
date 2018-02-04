package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/2/18.
 */
public class SampleObjects {
    public AppiumDriver driver;

    @AndroidFindBy(accessibility = "login")
    public MobileElement login;

    public SampleObjects(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                15, TimeUnit.MILLISECONDS),this);

        this.driver=driver;
    }

    public SecondPage clicklogin() throws InterruptedException {
        Thread.sleep(1000);
        login.click();
        Thread.sleep(1000);
       // chainedView.click();
        //return new SecondPage();
        return new SecondPage(driver);
    }

}
