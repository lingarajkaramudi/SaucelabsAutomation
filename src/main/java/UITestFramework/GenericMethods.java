package UITestFramework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericMethods {

    WebDriver driver = null;

    // common timeout for all tests can be set here
    public final int timeOut = 40;

    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping,
     *                              or otherwise occupied, and the thread is interrupted, either before
     *                              or during the activity.
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException {
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public boolean waitForVisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            throw e;

        }
    }


    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public WebElement findElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }
    }

    /**
     * method to launchApp
     */

    public void launchApp() {
        ((AppiumDriver) driver).launchApp();
    }


    public  boolean scrollToElement (By by) throws Exception {
        boolean isFoundTheElement = driver.findElements(by).size() > 0;
        while (isFoundTheElement == false) {
            swipeVertical(0.8, 0.1, 0.5, 2000);
            isFoundTheElement = driver.findElements(by).size() > 0;
        }

        return isFoundTheElement;
    }

    public  void swipeVertical (
            double startPercentage, double finalPercentage, double anchorPercentage, int duration)
            throws Exception {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        getTouchAction().press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(anchor, endPoint)).release().perform();
    }

    public  TouchAction getTouchAction () {
        return new TouchAction((PerformsTouchActions) driver);
    }
    

}
