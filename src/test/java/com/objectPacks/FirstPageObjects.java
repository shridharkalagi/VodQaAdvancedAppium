package com.objectPacks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by shridhk on 2/3/18.
 */
public class FirstPageObjects {

    @AndroidFindBy (accessibility = "login")
    public MobileElement loginButton;
}
