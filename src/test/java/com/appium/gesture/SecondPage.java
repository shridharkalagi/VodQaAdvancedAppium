package com.appium.gesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/2/18.
 */
public class SecondPage {

    @AndroidFindBy(accessibility = "chainedView")
    public MobileElement chainedView;

    public SecondPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                15, TimeUnit.MILLISECONDS), this);

    }



    public void clickChainedView() throws InterruptedException {
        Thread.sleep(1000);
        chainedView.click();
        Thread.sleep(1000);
        // chainedView.click();
        //return new SecondPage();
    }
}
