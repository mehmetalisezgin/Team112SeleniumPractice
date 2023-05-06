package week02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class IframeGuru extends TestBase {

    /*
    1-Navigate to http://demo.guru99.com/test/guru99home/
    2-Find the number of iframes on the page.
    3-Click on the first iframe button that contains a Youtube video.
    4-Exit from the first iframe and return to the main page.
    5-Click on the second iframe button that has the text "JMeter Made Easy"
    and navigate to the page https://www.guru99.com/live-selenium-project.html.

     */

    @Test
    public void iframeTest() {
        // 1-Navigate to http://demo.guru99.com/test/guru99home/
        driver.get("https://demo.guru99.com/test/guru99home/");
        // Handle cookies
        WebElement cookiesFrame = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(cookiesFrame);
        driver.findElement(By.xpath("//button[@id='save']")).click();
        driver.switchTo().defaultContent();
        ReusableMethods.waitFor(1);

        // 2-Find the number of iframes on the page. (expected #iframe = 6 )
        int numberOfIframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("The number of Iframe is : "+numberOfIframes);

        //  3-Click on the first iframe button that contains a Youtube video.
        WebElement youtubeFrame = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        ReusableMethods.waitFor(3);

        // 4-Exit from the first iframe and return to the main page.
        driver.switchTo().defaultContent();

        // 5-Click on the second iframe button that has the text "JMeter Made Easy"
        // and navigate to the page https://www.guru99.com/live-selenium-project.html.
        WebElement jMeterMadeEasyFrame = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jMeterMadeEasyFrame);
        driver.findElement(By.tagName("a")).click();
        ReusableMethods.waitFor(3);
    }





}
