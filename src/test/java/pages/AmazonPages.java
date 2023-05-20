package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonPages {


    public AmazonPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //*************************** Main Page *********************************************************
    @FindBy (xpath = "(//span[normalize-space()='Hello, sign in'])[1]")
    public WebElement singInButton ;
    @FindBy (xpath = "(//a[normalize-space()='Create your Amazon account'])[1]")
    public WebElement createAnAmazonUser ;

    @FindBy (xpath = "(//input[@placeholder='Search Amazon.co.uk'])[1]")
    public WebElement searchTextBox ;

    @FindBy (xpath = "(//input[@value='Go'])[1]")
    public WebElement searchTextBoxButton ;

    @FindBy (xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Nutella Hazelnut Chocolate Spread, 400 g, Pack of ')])[1]")
    public WebElement nutella ;



    // ********************* Amazon Main Page>> Sign In Button>>Create a user button>> Create account Page ***********
    @FindBy (xpath = "(//input[@placeholder='First and last name'])[1]")
    public WebElement createAccountFirstName ;
    @FindBy (xpath = "(//input[@type='email'])[1]")
    public WebElement mobileOrEmailTextBox ;
    @FindBy (xpath = "(//input[@placeholder='At least six characters'])[1]")
    public WebElement passwordTextBox ;
    @FindBy (xpath = "(//input[@class='a-input-text a-span12 auth-required-field auth-require-fields-match'])[1]")
    public WebElement reEnterpasswordTextBox ;
    @FindBy (xpath = "(//input[@type='submit'])[1]")
    public WebElement continueSubmitButton ;

    @FindBy (xpath = "(//h1[normalize-space()='Create account'])[1]")
    public WebElement createAccountHeaderText ;




  //******************************************* METHODS *****************************************
// There are two type of methods
    // one of them reads data from Config.properties file,
    // other one send data with manually
    public void singInButtonClick(){
        singInButton.click();
    }

    public void createAnAmazonUserClick(){
        createAnAmazonUser .click();
    }

    public void createAccountFirstNameSendText(String name){
        createAccountFirstName.sendKeys(name);
    }

    public void createAccountFirstName(){
        createAccountFirstName.sendKeys(ConfigReader.getProperty("name"));
    }

    public void mobileOrEmailTextBoxSendText(String text){
        mobileOrEmailTextBox.sendKeys(text);
    }
    public void mobileOrEmailTextBox(){
        mobileOrEmailTextBox.sendKeys(ConfigReader.getProperty("mobileNumber"));
    }
    public void passwordSendText(String text){
        passwordTextBox.sendKeys(text);
    }
    public void passwordSend(){
        passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
    }
    public void reEnterpasswordTextBoxSendText(String text){
        reEnterpasswordTextBox.sendKeys(text);
    }
    public void reEnterpasswordTextBoxSend(){
        reEnterpasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
    }
    public void continueSubmitButtonClick(){
        continueSubmitButton.click();
    }

    public boolean createAccountHeaderTextIsVissible(){
        return createAccountHeaderText.isDisplayed();
    }

    public void createAccountHeaderTextIsDisplayed(){
        Assert.assertTrue(createAccountHeaderText.isDisplayed());
    }

    public void searchTextBoxSendText(String text){
        searchTextBox.sendKeys(text);
    }
    public void searchTextBoxButtonClick(){
        searchTextBoxButton.click();
    }


    public boolean nutellaIsVissible(){
        return nutella.isDisplayed();
    }

    public void nutellaIsDisplayed(){
        Assert.assertTrue(nutella.isDisplayed());
    }
}
