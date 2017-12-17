package com.thetestroom.cucumber.steps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        timeoutSeconds(5);
    }

    public void timeoutSeconds(int howlong) {
        driver.manage().timeouts().implicitlyWait(howlong, TimeUnit.SECONDS);
    }

}
