package com.TestFinalPune;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/4/18.
 */
public class LoginPagePuneFinal extends UtilFinalPune {
    public LoginPagePuneFinal(AppiumDriver driver) {
        super(driver);
        loginPagePuneFinalObjects = new LoginPagePuneFinalObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS)
                , loginPagePuneFinalObjects);
    }

    LoginPagePuneFinalObjects loginPagePuneFinalObjects;

    public PasswordEntryPage enterUsernameAndClickNext(String s) {
        loginPagePuneFinalObjects.userName.sendKeys(s);
        waitForElement(loginPagePuneFinalObjects.nextButton).click();
        return new PasswordEntryPage(driver);
    }


}
