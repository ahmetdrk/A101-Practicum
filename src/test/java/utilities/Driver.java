package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver() {

    }

    /*
    we make WebDriver private, because we want to close access from outside the class
    we make it static because we will use it in a static method.
     */
    private static WebDriver driver;

    /*
    create a re-usable utility method which will return same driver instance when we call it
    */
    public static WebDriver getDriver() {

        if (driver == null) {

            /*
            we read our browserType from configuration.properties
            This way we can control which browser is opened from outside our code from configuration.properties

            */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            depending on the browserType that will be return from configoration.properties file
            switch statement will determine the case, and open the matching browser
             */

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }

    /*
    this method will make sure our driver value is always null after using quit method
     */

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();  // this line will terminate the existing session. value will not even be null
            driver = null;
        }
    }
}
