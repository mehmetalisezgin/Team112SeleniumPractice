package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ReusableMethods extends TestBase {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

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

        // take a screenshot of the page

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

    public static void screenshotMethod() {
        TakesScreenshot tss = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File allPage = new File("target/screenShot/allPage" + date + ".jpeg");
        File temporary = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporary, allPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}