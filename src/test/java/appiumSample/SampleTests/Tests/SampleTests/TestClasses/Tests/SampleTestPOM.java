package appiumSample.SampleTests.Tests.SampleTests.TestClasses.Tests;

import appiumSample.SampleTests.Tests.SampleTests.TestClasses.Pages.PasswordPage1;
import appiumSample.SampleTests.Tests.SampleTests.TestClasses.Pages.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by shridhk on 2/3/18.
 */
public class SampleTestPOM extends BaseClassSample {

    @Test
    public void SampleTest() {


        //driver.hideKeyboard();
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.enterUserNameAndContinue().clickPasswordLink();

//        PasswordPage1 passwordPage1 = new PasswordPage1(driver);
//        passwordPage1.clickPasswordLink();

        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/nux_sign_in_button")));
//        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/password_layout")));
        driver.findElementById("org.wordpress.android:id/password_layout").click();


        driver.findElementById("org.wordpress.android:id/nux_password").sendKeys("Hello12345678");
        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/my_site_blog_posts_text_view")));
        driver.findElementById("org.wordpress.android:id/my_site_blog_posts_text_view").click();


        new WebDriverWait(driver, 50).
                until(ExpectedConditions.
                        elementToBeClickable(By.id("org.wordpress.android:id/card_view")));

        String text = driver.findElementById("org.wordpress.android:id/text_title").getText();
        Assert.assertTrue(text.contains("Vod"));
    }
}

