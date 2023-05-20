package week01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utilities.ReusableMethods.screenshotMethod;

public class Class01_Driver {


    public static void main(String[] args) {

        // We define the driver (chrome, firefox...) and its path to the driver executable
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        // This line of code creates a new instance of the ChromeDriver in the Selenium WebDriver
        // and assigned it to a variable named chromeDriver.
       WebDriver chromeDriver = new ChromeDriver() ;
       chromeDriver.get("https://www.amazon.com/");
        screenshotMethod();
       // close() method is used to close the current browser or tab that the Webdriver instance is currently controlling.
       chromeDriver.close();
       // quit() method is used to close all browser windows and tabs that the Webdriver instance is currentlu controlling
       chromeDriver.quit();

       WebDriver firefoxDriver = new FirefoxDriver() ;
       firefoxDriver.get("https://www.amazon.com/");

       firefoxDriver.close();

       firefoxDriver.quit();

    }

}
