package com.pagePack;

import com.HelpersNew;
import com.objectPacks.FirstPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/3/18.
 */
public class PageOne extends HelpersNew  implements IPageOne{

    AppiumDriver driver;
    public PageOne(AppiumDriver driver) {
        super(driver);
        firstPageObjects = new FirstPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                15, TimeUnit.MILLISECONDS),firstPageObjects);
        this.driver=driver;
    }

    FirstPageObjects firstPageObjects;


//    @Override
//    public ThirdPage clickLogin(){
//        waitForElement(firstPageObjects.loginButton);
//        firstPageObjects.loginButton.click();
//        return new ThirdPage(driver);
//    }
}
