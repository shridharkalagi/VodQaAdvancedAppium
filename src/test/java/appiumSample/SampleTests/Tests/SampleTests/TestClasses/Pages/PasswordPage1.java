package appiumSample.SampleTests.Tests.SampleTests.TestClasses.Pages;

import appiumSample.SampleTests.Tests.SampleTests.TestClasses.ObjectPack.PasswordPageObjects1;
import appiumSample.SampleTests.Tests.SampleTests.TestClasses.UtilsSample1.UtilsSampleClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


/**
 * Created by shridhk on 2/4/18.
 */
public class PasswordPage1 extends UtilsSampleClass {
    PasswordPageObjects1 passwordPageObjects1;

    public PasswordPage1(AppiumDriver driver) {
        super(driver);
        passwordPageObjects1 = new PasswordPageObjects1();
        PageFactory.initElements
                (new AppiumFieldDecorator
                                (driver, 15,
                                        TimeUnit.SECONDS),
                        passwordPageObjects1);
    }

    public void clickPasswordLink() {
        waitforElement(passwordPageObjects1.passwordButton).click();
    }
}
