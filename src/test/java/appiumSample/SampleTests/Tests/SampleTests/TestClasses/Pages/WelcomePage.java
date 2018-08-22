package appiumSample.SampleTests.Tests.SampleTests.TestClasses.Pages;


import appiumSample.SampleTests.Tests.SampleTests.TestClasses.ObjectPack.WelcomePageObjectsSample;
import appiumSample.SampleTests.Tests.SampleTests.TestClasses.UtilsSample1.UtilsSampleClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shridhk on 2/4/18.
 */
public class WelcomePage extends UtilsSampleClass{

    WelcomePageObjectsSample welcomePageObjects;
    AppiumDriver driver;
    public WelcomePage(AppiumDriver driver) {
        super(driver);
        this.driver=driver;
        welcomePageObjects = new WelcomePageObjectsSample();
        PageFactory.initElements
                (new AppiumFieldDecorator
                        (driver,15,
                                TimeUnit.SECONDS),
                        welcomePageObjects);
    }

    public PasswordPage1 enterUserNameAndContinue(){
        welcomePageObjects.userName.sendKeys("vodqa@gmail.com");
        waitforElement(welcomePageObjects.nextButton).click();
        return new PasswordPage1(driver);

    }
}
