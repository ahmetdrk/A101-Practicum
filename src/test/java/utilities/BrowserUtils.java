package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute
    Thread.sleep for given duration
         */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }


    }


    /*
    This method accepts 3 arguments
    1-webdriver
    2-expectedInUrl
    3-expectedInTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        // Assert:Title contains "Etsy"
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    /*
    creating a utility method for Explicitwait, so we don't have to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));


    }

    public static void waitFor(int i) {
    }

    public static void waitForClickablility(WebElement dizaltiCorap, int i) {
    }

    public static void waitForStaleElement(WebElement adres, int i) {
    }

    public static void waitForVisibility(WebElement kartİleÖdeme, int i) {
    }
}
