package com.vodqa2018samples;

import com.appium.gesture.BaseUserTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
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
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                source.x / 2, source.y + 400));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), source.getX() / 2, source.y / 2));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    @Test
    public void multiTouchSliderTest() throws InterruptedException {
        login();
        wait.until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("slider1"))).click();
        Thread.sleep(3000);
        MobileElement slider = driver.findElementByAccessibilityId("slider");
        MobileElement slider1 = driver.findElementByAccessibilityId("slider1");

        Point source1 = slider.getLocation();
        Point source2 = slider1.getLocation();

        PointerInput pointerInput1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput pointerInput2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence swipe1 = new Sequence(pointerInput1, 0);
        swipe1.addAction(pointerInput1.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source1.getX(), source1.getY()));
        swipe1.addAction(pointerInput1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe1.addAction(pointerInput1.createPointerMove(Duration.ofMillis(5000),
                PointerInput.Origin.viewport(), source1.getX() + 200, source1.getY()));
        swipe1.addAction(pointerInput1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence swipe2 = new Sequence(pointerInput2, 0);
        swipe2.addAction(pointerInput2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source2.getX(), source2.getY()));
        swipe2.addAction(pointerInput2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe2.addAction(pointerInput2.createPointerMove(Duration.ofMillis(5000),
                PointerInput.Origin.viewport(), source2.getX() + 200, source2.getY()));
        swipe2.addAction(pointerInput2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe1, swipe2));

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        login();
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("dragAndDrop").click();
        MobileElement dragMe = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions
                .elementToBeClickable(MobileBy.AccessibilityId("dragMe")));
        Point source = dragMe.getCenter();
        Point target = driver.findElementByAccessibilityId("dropzone").getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                target.x, target.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }

    @Test
    public void pinchAndZoom() throws InterruptedException {
        login();
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("photoView").click();
        Thread.sleep(3000);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Dimension size = driver.manage().window().getSize();
        Point source = new Point(size.getWidth(), size.getHeight());

        Sequence pinchAndZoom1 = new Sequence(finger, 0);
        pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x / 2, source.y / 2));
        pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(10000),
                PointerInput.Origin.viewport(), source.x / 3, source.y / 3));
        pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence pinchAndZoom2 = new Sequence(finger2, 0);
        pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x / 2, source.y / 2));
        pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(10000),
                PointerInput.Origin.viewport(), source.x * 3 / 4, source.y * 3 / 4));
        pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
    }
}
