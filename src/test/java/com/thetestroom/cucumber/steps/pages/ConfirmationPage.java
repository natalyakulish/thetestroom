package com.thetestroom.cucumber.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends Page {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        WebElement confirmationElement = driver.findElement(By.xpath("//div/p"));
        return confirmationElement.getText();
    }

    public HomePage backToHome() {
        driver.findElement(By.id("back_button")).click();
        return new HomePage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
