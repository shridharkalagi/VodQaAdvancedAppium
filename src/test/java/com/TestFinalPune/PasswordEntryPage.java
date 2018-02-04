package com.TestFinalPune;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/4/18.
 */
public class PasswordEntryPage extends UtilFinalPune {
    PasswordPageObjects passwordPageObjects;
    public PasswordEntryPage(AppiumDriver driver) {
        super(driver);

        passwordPageObjects = new PasswordPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator
                (driver,15, TimeUnit.SECONDS),passwordPageObjects);

    }

    public void clickEnterPassword() {
        waitForElement(passwordPageObjects.enterPasswordButton).click();
    }
}
