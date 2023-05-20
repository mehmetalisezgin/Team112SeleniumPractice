package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class PagesAutomationExcercise extends TestBase {

    // Sign/Login Button on the Main Page
    public static void logInButtonMainPageClick(){
        WebElement logInButtonMainPage = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        logInButtonMainPage.click();
    }

    // User name text box on the login page
    public static void usernameTextBoxSendKeys(String text){
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        usernameTextBox.sendKeys(text);
    }


    // password text box on the login page
    public static void passwordTextBoxSendKeys(String text){
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordTextBox.sendKeys(text);
    }

    // Sign inButton in login page
    public static void sigInButtonClick(){
        WebElement userLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        userLoginButton.click();
    }

    /*
      usernameTextBoxSendKeys("mhmetaliszgn@gmail.com");
        passwordTextBoxSendKeys("ervanaz2012");
     */

}
