package cucumberIntegrationTests.stepDefinitions.common;

import cucumber.api.java.en.Given;
import cucumberIntegrationTests.CreateSessionCucumber;
import cucumberIntegrationTests.screens.android.ScreenObjects;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    CreateSessionCucumber createSessionCucumber;
    WebDriver driver;
    String platform;
    ScreenObjects screenObjects;

    @Given("I launch the app")
    public void createDriver() throws Exception {
        createSessionCucumber = new CreateSessionCucumber();
        createSessionCucumber.createDriver();
        driver = createSessionCucumber.getWebDriver();
        screenObjects = new ScreenObjects(driver);
    }
}
