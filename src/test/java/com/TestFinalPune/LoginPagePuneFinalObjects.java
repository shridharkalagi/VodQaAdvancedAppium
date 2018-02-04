package com.TestFinalPune;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by shridhk on 2/4/18.
 */
public class LoginPagePuneFinalObjects {

    @AndroidFindBy (id = "org.wordpress.android:id/nux_username")
    public MobileElement userName;

    @AndroidFindBy(id =  "org.wordpress.android:id/nux_sign_in_button")
    public MobileElement nextButton;
}
