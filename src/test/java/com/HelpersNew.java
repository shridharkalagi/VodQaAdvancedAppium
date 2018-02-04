package com;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shridhk on 2/3/18.
 */
public class HelpersNew {

    public AppiumDriver driver;
    private WebDriverWait webDriverWait;

    public HelpersNew(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public void waitForElement(MobileElement by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
