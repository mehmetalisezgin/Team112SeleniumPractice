package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.TestBase.driver;


public class DemoqaWebsitePages  {

    public static Object getHeadersText(int index) {
        List<WebElement> headrTextList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        return headrTextList.get(index).getText();
    }
    public static void verifyEmployeeDataText(String firstName, String lastName, String age, String email, String salary,
                                              String department) {
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        List<WebElement> rows = tableBody.findElements(By.xpath(".//div[@class='rt-tr-group']"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div[@class='rt-td']"));
            String cellFirstName = cells.get(0).getText();
            String cellLastName = cells.get(1).getText();
            String cellAge = cells.get(2).getText();
            String cellEmail = cells.get(3).getText();
            String cellSalary = cells.get(4).getText();
            String cellDepartment = cells.get(5).getText();

            Assert.assertEquals(firstName, cellFirstName);
            Assert.assertEquals(lastName, cellLastName);
            Assert.assertEquals(age, cellAge);
            Assert.assertEquals(email, cellEmail);
            Assert.assertEquals(salary, cellSalary);
            Assert.assertEquals(department, cellDepartment);
        }
    }

    // Step 2: Identify the dropdown element for selecting the number of rows per page.
    public static void listOfNumberRowsClick() {
        WebElement listNumberOfRows = driver.findElement(By.xpath("(//select[@aria-label='rows per page'])[1]"));
        listNumberOfRows.click();
    }
    //  Step 4: Identify the first option in the dropdown with a value of '5'.
    public static void rowsDropDownListClick(int rows){
        WebElement options = driver.findElement(By.xpath("//option[@value='"+rows+"']"));
        options.click();
    }

    public static int numberOfRows(){
        List<WebElement> rowList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        return rowList.size();
    }
}
