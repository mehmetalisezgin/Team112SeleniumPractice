package week02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static pages.PagesAutomationExcercise.*;

public class AutomationExercisesWebSite extends TestBase {

    /*
    Test Case 1: Verify the Login Functionality
    1- Launch the website https://automationexercise.com/
    2- Click on the "Login" button on the top right corner of the page
    3- Enter a valid email address and password in the respective fields
    4- Click on the "Sign in" button
    5- Verify that the user is logged in by checking if the "My account" page is displayed
    6- Logout of the website
     */




    @Test
    public void logInFunctionality() {
        // 1- Launch the website https://automationexercise.com/
        driver.get("https://automationexercise.com/");
        // 2- Click on the "Login" button on the top right corner of the page
        logInButtonMainPageClick();
        // 3- Enter a valid email address and password in the respective fields
        usernameTextBoxSendKeys("mhmetaliszgn@gmail.com");
        passwordTextBoxSendKeys("ervanaz2012");
        // 4- Click on the "Sign in" button
        sigInButtonClick();
        // 5- Verify that the user is logged in by checking if the "Logout" button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        Assert.assertTrue("Log out Button is not Displayed", logoutButton.isDisplayed());
        driver.quit();
    }

     /*
    Test Case 2: Login User with incorrect email and password
    1- Launch the website https://automationexercise.com/
    2. Verify that home page is visible successfully
    3. Click on 'Signup / Login' button
    4. Verify 'Login to your account' is visible
    5. Enter incorrect email address and password
    6. Click 'login' button
    7. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test
    public void loginWithIncorrectEmailAndPassword() {
        // 1- Launch the website https://automationexercise.com/
        driver.get("https://automationexercise.com/");
        // 2. Verify that home page is visible successfully
        String titleoFWebsite = driver.getTitle();
        Assert.assertEquals("Automation Exercise", titleoFWebsite);

        // 3. Click on 'Signup / Login' button
        logInButtonMainPageClick();

        // 4. Verify 'Login to your account' is visible
        WebElement loginToYourAccountText = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue("Login To Your Account Header Text Is not Displayed", loginToYourAccountText.isDisplayed());

        // 5. Enter incorrect email address and password
        usernameTextBoxSendKeys("mhmetaszgn@gmail.com");
        passwordTextBoxSendKeys("ervanaz");

        // 6. Click 'Sign in' button
        sigInButtonClick();

        // 7. Verify error 'Your email or password is incorrect!' is visible
        WebElement emailAndPasswordWarningMessage =
                driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));

        Assert.assertTrue("The Warning Message is not Visible", emailAndPasswordWarningMessage.isDisplayed());

    }

     /*
     Test Case 3: Logout User
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter correct email address and password
     7. Click 'login' button
     8. Verify that 'Logged in as username' is visible
     9. Click 'Logout' button
     10. Verify that user is navigated to login page
      */


}
