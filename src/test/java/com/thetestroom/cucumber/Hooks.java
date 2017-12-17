package com.thetestroom.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setup() {
        WebDriverUtils.getNewChromeDriver();
    }

    @After
    public void tearDown() {
        WebDriverUtils.closeDriver();
    }
}
