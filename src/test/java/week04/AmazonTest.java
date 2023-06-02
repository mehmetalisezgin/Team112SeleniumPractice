package week04;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.testng.annotations.*;
import pages.AmazonPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class AmazonTest {

    /*
    Test Case 1: Verify Login Functionality
    Description: Ensure that users can successfully log in to their Amazon accounts.
    Steps:
    Navigate to the Amazon website.
    Click on the "Sign In" button.
    Enter valid login credentials (email/username and password).
    Click on the "Sign In" button.
    Verify that the user is logged in and redirected to the homepage.
     */
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    private AmazonPages amazonPages;

    @BeforeMethod
    public void setUp() {
        // Navigate to the Amazon website.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentReports = new ExtentReports();
        extentTest = extentReports.createTest("Amazon Web Page Test", "accessed the amazon web page");
        amazonPages = new AmazonPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


    @Test(priority = 2)
    public void testLoginFunctionality() {
        //  Click on the "Sign In" button.
        //amazonPages.singInButton.click(); this way also true but i would like to use on methods
        amazonPages.singInButtonClick();
        // click on create a user button
        amazonPages.createAnAmazonUserClick();
        // Enter valid name in the name text box
        waitFor(2);
        amazonPages.createAccountHeaderTextIsVissible();// this is a boolean method
        amazonPages.createAccountFirstName(); // name is called from config.properties file
        // Enter a valid mobile/email/password
        amazonPages.mobileOrEmailTextBox();//  from config.properties
        amazonPages.passwordSend();
        waitFor(2);
        amazonPages.reEnterpasswordTextBoxSend();
        amazonPages.continueSubmitButtonClick();
        // Verify that the user is logged in and redirected to the homepage.
    }


    @Test(priority = 3)
    public void testLoginFunctionality01() {
        //  Click on the "Sign In" button.
        //amazonPages.singInButton.click(); this way also true but i would like to use on methods
        amazonPages.singInButtonClick();
        // click on create a user button
        amazonPages.createAnAmazonUserClick();
        // Enter valid name in the name text box
        waitFor(2);
        amazonPages.createAccountHeaderTextIsDisplayed();// this is a void method used with Assertion
        amazonPages.createAccountFirstNameSendText("T112"); // here we typed name manually
        amazonPages.mobileOrEmailTextBoxSendText("+38630335147");// with manual
        amazonPages.passwordSendText("Team112");
        waitFor(2);
        amazonPages.reEnterpasswordTextBoxSendText("Team112");
        amazonPages.continueSubmitButtonClick();
    }
/*
Test Case 2: Search for a Product
Description: Validate the search functionality on the Amazon website.
Steps:
Navigate to the Amazon website.
Enter a specific product name or keyword in the search bar.
Click on the search button.
Verify that the search results page is displayed with relevant products.
Validate that the displayed products match the entered keyword.
 */
    @Test (priority = 1)
    public void searchProductTest() {
        // Enter a specific product name or keyword in the search bar.
        amazonPages.searchTextBoxSendText("Nutella") ;
        // Click on the search button.
        amazonPages.searchTextBoxButtonClick();
        waitFor(1);
        // Verify that the search results page is displayed with relevant products.
        amazonPages.nutellaIsVissible();
    }





    @Test
    public void Test05() {
        amazonPages.searchTextBoxSendText("Nutella") ;
        // Click on the search button.
        amazonPages.searchTextBoxButtonClick();
        waitFor(1);
        // Verify that the search results page is displayed with relevant products.
        amazonPages.nutellaIsVissible();
    }
    @Test
    public void Test01() {
        amazonPages.searchTextBoxSendText("Nutella") ;
        // Click on the search button.
        amazonPages.searchTextBoxButtonClick();
        waitFor(1);
        // Verify that the search results page is displayed with relevant products.
        amazonPages.nutellaIsVissible();
    }


}
