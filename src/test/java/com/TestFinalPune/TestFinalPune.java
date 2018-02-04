package com.TestFinalPune;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by shridhk on 2/4/18.
 */
public class TestFinalPune extends BaseTestPuneFinal {

    @Test
    public void SampleTest() {

//        driver.hideKeyboard();

        LoginPagePuneFinal loginPagePuneFinal = new LoginPagePuneFinal(driver);
        loginPagePuneFinal.enterUsernameAndClickNext("vodqa@gmail.com").clickEnterPassword();
//
//
//        new WebDriverWait(driver, 50).
//                until(ExpectedConditions.
//                        elementToBeClickable(By.id("org.wordpress.android:id/nux_sign_in_button")));
//        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();
//


//
//        new WebDriverWait(driver, 50).
//                until(ExpectedConditions.
//                        elementToBeClickable(By.id("org.wordpress.android:id/password_layout")));
//        driver.findElementById("org.wordpress.android:id/password_layout").click();
//

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

        Assert.assertTrue(text.contains("VodQA"));
    }

}
