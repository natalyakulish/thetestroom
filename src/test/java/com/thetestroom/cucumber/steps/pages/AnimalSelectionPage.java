package com.thetestroom.cucumber.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AnimalSelectionPage extends Page {

    public AnimalSelectionPage(WebDriver driver) {
        super(driver);
    }

    public AnimalSelectionPage selectAnimal(String animalName) {
        WebElement animalNames = driver.findElement(By.xpath("//select[@class='ng-pristine ng-valid']"));

        Select select = new Select(animalNames);
        select.selectByVisibleText(animalName);

        return new AnimalSelectionPage(driver);
    }
}
