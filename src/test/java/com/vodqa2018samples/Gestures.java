package com.vodqa2018samples;

import com.appium.gesture.BaseUserTest;
import io.appium.java_client.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

/**
 * Created by shridhk on 9/10/18.
 */
public class Gestures extends BaseUserTest {
    private AppiumDriverLocalService service;
    public AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    private void login() {
        wait.until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("login"))).click();
    }


    @Test
    public void horizontalSwipingTest() throws Exception {
        login();
        driver.findElementByAccessibilityId("slider1").click();
        MobileElement slider = driver.findElementByAccessibilityId("slider");

        Point source = slider.getLocation();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                source.x + 400, +source.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    @Test
    public void verticalSwipeTest() throws InterruptedException {
        login();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("verticalSwipe")));
        driver.findElementByAccessibilityId("verticalSwipe").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("listview")));
        verticalSwipe("listview");
    }

    private void verticalSwipe(String locator) throws InterruptedException {
        Thread.sleep(3000);
        MobileElement slider = driver.findElementByAccessibilityId(locator);
        Point source = slider.getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                source.x / 2, source.y + 400));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), source.getX() / 2, source.y / 2));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }

    @Test
    public void multiTouchSliderTest() throws InterruptedException {
        login();
        wait.until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("slider1"))).click();
        Thread.sleep(3000);
        MobileElement slider = driver.findElementByAccessibilityId("slider");
        MobileElement slider1 = driver.findElementByAccessibilityId("slider1");

        Dimension sizeSlider = slider.getSize();
        Dimension sizeSlider1 = slider1.getSize();
        TouchAction touchAction1 =
                new TouchAction(driver).press(ElementOption.element(slider, 0, sizeSlider.height / 2))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(ElementOption.element(slider, sizeSlider.width / 2, sizeSlider.height / 2));
        TouchAction touchAction2 =
                new TouchAction(driver).press(ElementOption.element(slider1, 0, sizeSlider1.height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(ElementOption.element(slider1, sizeSlider1.width / 2, sizeSlider1.height / 2));
        new MultiTouchAction(driver).add(touchAction1).add(touchAction2).perform();
        Thread.sleep(2000);
    }


}
