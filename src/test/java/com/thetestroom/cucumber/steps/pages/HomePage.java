package com.thetestroom.cucumber.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage inputName(String name) {
        WebElement nameInput = driver.findElement(By.xpath("//input[@class='ng-pristine ng-valid']"));
        nameInput.sendKeys(name);
        return new HomePage(driver);
    }

    public String getName() {
        WebElement nameElement = driver.findElement(By.xpath("//h2[@class='ng-binding']"));
        return nameElement.getText();
    }

    public AnimalSelectionPage openAnimalSelectionPage() {
        driver.findElement(By.id("continue_button")).click();
        return new AnimalSelectionPage(driver);
    }
}
