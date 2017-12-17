package com.thetestroom.cucumber.steps;

import com.thetestroom.cucumber.WebDriverUtils;
import com.thetestroom.cucumber.steps.pages.AnimalSelectionPage;
import com.thetestroom.cucumber.steps.pages.ConfirmationPage;
import com.thetestroom.cucumber.steps.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AnimalAdoption {

    private WebDriver driver = WebDriverUtils.getExistingChromeDriver();

    @Given("^User is on \"([^\"]*)\" page$")
    public void user_is_on_page(String pageName) throws Throwable {
        if (pageName.equals("Home")) {
            driver.get("http://www.thetestroom.com/jswebapp/index.html");
        } else {
            throw new IllegalArgumentException(pageName + " is invalid page");
        }
    }

    @When("^User input \"([^\"]*)\"$")
    public void user_input(String name) throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.inputName(name);
    }

    @Then("^\"([^\"]*)\" is displayed$")
    public void is_displayed(String name) throws Throwable {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(name, homePage.getName());
    }

    @When("^User presses \"([^\"]*)\" button$")
    public void user_presses_button(String buttonName) throws Throwable {
        if (buttonName.equals("Continue")) {
            HomePage homePage = new HomePage(driver);
            homePage.openAnimalSelectionPage();
        } else if (buttonName.equals("Back to home")){
            ConfirmationPage confirmationPage = new ConfirmationPage(driver);
            confirmationPage.backToHome();
       }
        else {
            throw new IllegalArgumentException(buttonName + " is invalid button");
        }
    }

    @When("^User selects \"([^\"]*)\"$")
    public void user_selects(String animalName) throws Throwable {
        AnimalSelectionPage animalSelectionPage = new AnimalSelectionPage(driver);
        animalSelectionPage.selectAnimal(animalName);
    }

    @Then("^confirmation text \"([^\"]*)\" is displayed$")
    public void confirmation_text_is_displayed(String text) throws Throwable {
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(text, confirmationPage.getText());
    }
    @Then("^User is not on \"([^\"]*)\" page$")
    public void user_is_not_on_page(String pageName) throws Throwable {
        if (pageName.equals("Confirmation")) {
            ConfirmationPage confirmationPage = new ConfirmationPage(driver);
            Assert.assertFalse(confirmationPage.getUrl().endsWith("confirm.html"));
        }

    }

}
