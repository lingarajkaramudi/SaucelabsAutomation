package cucumberIntegrationTests.stepDefinitions.common;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberIntegrationTests.CreateSessionCucumber;
import cucumberIntegrationTests.screens.android.ScreenObjects;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StepDefs {
    ScreenObjects screenObjects;
    WebDriver driver;
    String userName;
    String password;
    Properties configFileObject;
    BaseSteps baseStepsContext;

    public StepDefs(BaseSteps baseSteps) {
        baseStepsContext = baseSteps;
        driver = baseStepsContext.driver;
        screenObjects = baseStepsContext.screenObjects;
        configFileObject = CreateSessionCucumber.localeConfigProp;
    }

    @Given("^I am on login screen$")
    public void usernameAndPasswordIs() {
    }

    @When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersCredentials(String userName, String password) {
        screenObjects.waitForVisibility(screenObjects.userName);
        screenObjects.findElement(screenObjects.userName).sendKeys(userName);
        screenObjects.findElement(screenObjects.password).sendKeys(password);
    }

    @And("I tap on \"([^\"]*)\" button")
    public void tapsOnButton(String arg0) {
        screenObjects.findElement(screenObjects.signInButton).click();
    }

    @Then("\"([^\"]*)\" button should be visible")
    public void buttonShouldBeVisible(String button) {
        //	verify if "Get Started" button is displayed
        if(button.equalsIgnoreCase("Get Started")) {
            screenObjects.waitForVisibility(screenObjects.startedButton);
            screenObjects.findElement(screenObjects.startedButton).click();
        }
    }

    @And("^I scroll down$")
    public void scroll() throws InterruptedException {
        // scroll down twice with each duration of 500 ms
        screenObjects.scrollDown(2, 500);
    }

    @And("^I am on products screen$")
    public void iAmOnProductsScreen() {
        screenObjects.waitForVisibility(screenObjects.menuIcon);
    }

    @And("^I add item1 to cart$")
    public void iAddItem1ToCart() {
        screenObjects.findElement(screenObjects.addItem1).click();
    }

    @And("^I add item2 to cart$")
    public void iAddItem2ToCart() {
        screenObjects.findElement(screenObjects.addItem2).click();
    }

    @And("^I remove item1 from cart$")
    public void iRemoveItemFromCart() {
        screenObjects.findElement(screenObjects.removeItem1).click();
    }

    @And("^I click on cart$")
    public void iClickOnCart() {
        screenObjects.findElement(screenObjects.cartIcon).click();
    }

    @And("^I click on checkout button$")
    public void iClickOnCheckoutButton() {
        screenObjects.waitForVisibility(screenObjects.checkoutButton);
        screenObjects.findElement(screenObjects.checkoutButton).click();
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        screenObjects.waitForVisibility(screenObjects.continueButton);
        screenObjects.findElement(screenObjects.continueButton).click();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        screenObjects.waitForVisibility(screenObjects.finishButton);
        screenObjects.findElement(screenObjects.finishButton).click();
    }

    @And("^I verify the order$")
    public void iVerifyTheOrder() {
        screenObjects.waitForVisibility(screenObjects.thanksMessage);
        screenObjects.findElement(screenObjects.thanksMessage).getText().equals("THANK YOU FOR YOU ORDER");
    }

    @And("^I enter first name as \"([^\"]*)\"$")
    public void iEnterFirstNameAs(String firstName) {
        screenObjects.waitForVisibility(screenObjects.firstName);
        screenObjects.findElement(screenObjects.firstName).sendKeys(firstName);
    }

    @And("^I enter last name as \"([^\"]*)\"$")
    public void iEnterLastNameAs(String lastName) {
        screenObjects.waitForVisibility(screenObjects.lastName);
        screenObjects.findElement(screenObjects.lastName).sendKeys(lastName);
    }

    @And("^I enter postCode \"([^\"]*)\"$")
    public void iEnterPostCode(String postCode) {
        screenObjects.waitForVisibility(screenObjects.postCode);
        screenObjects.findElement(screenObjects.postCode).sendKeys(postCode);
    }

    @And("^I click on back button$")
    public void iClickOnBackButton() {
        screenObjects.findElement(screenObjects.backButton).click();
    }

    @And("^I click on menu$")
    public void iClickOnMenu() {
        screenObjects.waitForVisibility(screenObjects.menuIcon);
        screenObjects.findElement(screenObjects.menuIcon).click();
    }

    @And("^I logout$")
    public void iLogout() {
        screenObjects.waitForVisibility(screenObjects.logOutButton);
        screenObjects.findElement(screenObjects.logOutButton).click();
    }

}
