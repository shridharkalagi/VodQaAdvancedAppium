package com.TestFinalPune;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by shridhk on 2/4/18.
 */
public class PasswordPageObjects {

    @AndroidFindBy (id = "org.wordpress.android:id/password_layout")
    public MobileElement enterPasswordButton;
}
