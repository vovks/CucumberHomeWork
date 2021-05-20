package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constants;

public class DriverFactory {
    public static WebDriver createDriver(BrowserType browserName){
        //String browserName = "firefox";//path to file -> get property
        WebDriver driver = null;

        switch(browserName){
            case CHROME:
                System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER);
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
