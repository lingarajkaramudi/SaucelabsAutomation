package cucumberIntegrationTests.screens.android;

import UITestFramework.GenericMethods;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * contains all the locators present on the login Screen
 */
public class ScreenObjects extends GenericMethods {

	public ScreenObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	// Locators on the login screen
	public By loginHeader = By.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]");
	public By userName = MobileBy.AccessibilityId("test-Username");
	public By password = MobileBy.AccessibilityId("test-Password");
	public By signInButton = MobileBy.AccessibilityId("test-LOGIN");
	public By startedButton = By.id("net.slideshare.mobile:id/get_started_button");

	public By menuIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
	public By addItem1 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
	public By addItem2 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
	public By removeItem1 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[1]");
	public By cartIcon = By.xpath("//*[@content-desc=\"test-Cart\"]");
	public By checkoutButton = MobileBy.AccessibilityId("test-CHECKOUT");

	public By firstName =MobileBy.AccessibilityId("test-First Name");
	public By lastName =MobileBy.AccessibilityId("test-Last Name");
	public By postCode =MobileBy.AccessibilityId("test-Zip/Postal Code");
	public By continueButton =MobileBy.AccessibilityId("test-CONTINUE");
	public By finishButton = MobileBy.AccessibilityId("test-FINISH");

	public By thanksMessage = By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
	public By backButton = MobileBy.AccessibilityId("test-BACK HOME");

	public By logOutButton = MobileBy.AccessibilityId("test-LOGOUT");



	
}

