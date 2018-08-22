package appiumSample.SampleTests.Tests.SampleTests.TestClasses.UtilsSample1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shridhk on 2/4/18.
 */
public class UtilsSampleClass {

    public AppiumDriver driver;
    private WebDriverWait webDriverWait;

    public UtilsSampleClass(AppiumDriver driver) {
        this.driver=driver;
        webDriverWait = new WebDriverWait(driver,15);
    }

    public MobileElement waitforElement(MobileElement by){
        webDriverWait.until(
                ExpectedConditions.elementToBeClickable(by));

        return by;
    }
}
