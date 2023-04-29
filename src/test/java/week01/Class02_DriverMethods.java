package week01;

import com.google.common.annotations.VisibleForTesting;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Class02_DriverMethods {

    public static void main(String[] args) {
         // Test 01: Navigate www.marksandspencer.com and click on Kids button and select an item

        WebDriver chromeDriver = new ChromeDriver() ;
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.get("https://www.marksandspencer.com/");

        // click on Kids button ==>> firstly we should define webelement
       // WebElement kidsButton = chromeDriver.findElement(By.linkText("Kids"));
        WebElement kidsButton = chromeDriver.findElement(By.xpath("//a[text()='Kids']"));
        kidsButton.click();


        WebElement dressedButton = chromeDriver.findElement(By.xpath("//h2[text()='Dresses']"));
        dressedButton.click();

        // Let put all webelement of items in a list
        List<WebElement> priceListDresses = chromeDriver.findElements(By.xpath("//span[@class='css-v38gg3 et8tcrz0']")) ;


       // for(int i = 0 ; i<priceListDresses.size() ; i++){
       //     System.out.print(priceListDresses.get(i).getText());
       // }

        String strNumber = "" ;
        int number = 0 ;
        int maxPrice = 0;

        for (int i = 0 ; i<priceListDresses.size() ; i++){
            strNumber = priceListDresses.get(i).getText().substring(1,3);
            number = Integer.parseInt(strNumber);

            if (number>maxPrice){
                maxPrice=number ;
            }
        }
        System.out.println(maxPrice);
    }


    /*
    USER STORY : Filter page should be created regarding the acceptance criteria
    ( there should be 4 options, price, size, colour, brand )
    Test Cases :
    TC01 : Price option should work

    Test Steps
    1.step navigate url
    2.step main page should be visible
    3.step Click on the Filter page in button in the main page
    4.step Write price text box ......
    5.step Click on Filter button in the Filter page
    6.step The filtered price should be visible on the main page


    TC02 : Size option should work
    TC03 : colour option should work
    TC04 : brand option should work
    TC05 : The filter webelements should be functional
     */

}
