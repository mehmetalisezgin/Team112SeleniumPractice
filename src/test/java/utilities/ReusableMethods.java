package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class ReusableMethods  {
    // this method allows you to pause the program's execution for a given number of seconds before continuing.
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    // this method opens an Excel file, reads the value from the specified row and cell, and prints it to the console.
    public static void getvalueOfExcelFileUsingRowAndCell(int row, int cell) {
        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        Workbook workbook = null;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {

        }
        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(cell));
    }

    public static void fullPageScreenShot(WebDriver driver) {
        //1 ) Create a screenshot object
        TakesScreenshot tss = (TakesScreenshot) driver;
            /*
                We saved different SS by using the same name. So previous saves are not being stored. Only the last
                SS will remeain in the project

                To solve this problem we should create a unique name for each SS and all ScreenShots will be saved

                We will use datetime to create a unique name
            */
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);
        // we have created the date. Now we should add it to the file name ( path)
        // creating a file path for our ss
        String filePath = "target/fullPageSS/ScreenShotSS"+ date  +".jpeg";
        // creating the file
        File FullPageSS = new File(filePath);
        //creting a tempfile to save ss ( otherwise it does not work)
        File tempFile = tss.getScreenshotAs(OutputType.FILE);
        // coping copy file to the orinigal file
        try {
            FileUtils.copyFile(tempFile,FullPageSS);
        } catch (IOException e) {
        }
    }
     //  this method captures a screenshot of a webpage using a provided driver, saves it as a JPEG file
     //  with a timestamp in the filename, and stores it in the "target/screenShot" directory.
     // I recommend this method



    //========Switching Window=====//
    // this method switches the driver's focus to a window with a specific title.
    // If the target window is found, the method returns, and if not, it reverts
    // the focus back to the original window.
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//
    // this method moves the mouse cursor over a specified web
    // element using the "Actions" class in Selenium WebDriver.
    // It enables you to simulate a hover effect that triggers additional
    // actions or reveals hidden elements associated with the hovered element.
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    //when we sent a list of webelements, method returns us text of these webelements in a list
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    // when we sent a common locater of a lot of webelements, method will return text values of these
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeout) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1));//Check for the element every 1 second

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });

        return element;
    }

    // It is recommended to send screenshots method to the target folder
    // Because screenshots can get mixed up with other source files
    public static String screenshotMethod() {
        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File allPage = new File("/target/Screenshots/" + date + ".jpeg");
        File temporary = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporary, allPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allPage.getAbsolutePath();
    }

}