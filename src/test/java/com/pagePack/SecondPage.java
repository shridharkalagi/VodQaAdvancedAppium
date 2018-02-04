package com.pagePack;

import com.HelpersNew;
import com.objectPacks.SecondPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/3/18.
 */
public class SecondPage extends HelpersNew
{

    SecondPageObjects secondPageObjects;

    public SecondPage(AppiumDriver driver) {
        super(driver);
        secondPageObjects = new SecondPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver,15, TimeUnit.SECONDS),
                secondPageObjects);
    }

    public String clickChaninedView(){
        waitForElement(secondPageObjects.chainedView);
        secondPageObjects.chainedView.click();
        return secondPageObjects.text.getText();
    }
}
