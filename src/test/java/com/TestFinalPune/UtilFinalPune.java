package com.TestFinalPune;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shridhk on 2/4/18.
 */
public class UtilFinalPune {


    public AppiumDriver driver;
    private WebDriverWait webDriverWait;

    public UtilFinalPune(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public MobileElement waitForElement(MobileElement by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return by;
    }

}
