package com.objectPacks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by shridhk on 2/3/18.
 */
public class SecondPageObjects {

    @AndroidFindBy(accessibility = "chainedView")
    public MobileElement chainedView;

    @AndroidFindBy(accessibility = "container3")
    @AndroidFindBy(accessibility = "textView")
    public MobileElement text;
}
