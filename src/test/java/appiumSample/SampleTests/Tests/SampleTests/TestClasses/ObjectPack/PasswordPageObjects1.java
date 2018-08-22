package appiumSample.SampleTests.Tests.SampleTests.TestClasses.ObjectPack;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by shridhk on 2/4/18.
 */
public class PasswordPageObjects1 {

    @AndroidFindBy(id = "org.wordpress.android:id/password_layout")
    public MobileElement passwordButton;
}
