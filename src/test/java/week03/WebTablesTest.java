package week03;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import static pages.DemoqaWebsitePages.*;
import static utilities.ReusableMethods.screenshotMethod;
import static utilities.ReusableMethods.waitFor;

public class WebTablesTest extends TestBase {

    /*
    TC01 : Header Text Verification
    Step 1 : Navigate to the URL "https://demoqa.com/webtables".
    Step 2 : Wait for the page to load.
    Step 3 : Assert that the header text at index 0 is equal to "First Name".
    Step 4 : Assert that the header text at index 1 is equal to "Last Name".
    Step 5 : Assert that the header text at index 2 is equal to "Age".
    Step 6 : Assert that the header text at index 3 is equal to "Email".
    Step 7 : Assert that the header text at index 4 is equal to "Salary".
    Step 8 : Assert that the header text at index 5 is equal to "Department".
    Step 9 : Assert that the header text at index 6 is equal to "Action".
     */

    @Test
    public void headerTextVerification() {
        // Step 1 : Navigate to the URL "https://demoqa.com/webtables".
        driver.get("https://demoqa.com/webtables");
        // Step 2 : Wait for the page to load.
        waitFor(2);
        // Step 3 : Assert that the header text at index 0 is equal to "First Name".
        Assert.assertEquals("First Name", getHeadersText(0));
        // Step 4 : Assert that the header text at index 1 is equal to "Last Name".
        Assert.assertEquals("Last Name", getHeadersText(1));
        // Step 5 : Assert that the header text at index 2 is equal to "Age".
        Assert.assertEquals("Age", getHeadersText(2));
        // Step 6 : Assert that the header text at index 3 is equal to "Email".
        Assert.assertEquals("Email", getHeadersText(3));
        // Step 7 : Assert that the header text at index 4 is equal to "Salary".
        Assert.assertEquals("Salary", getHeadersText(4));
        // Step 8 : Assert that the header text at index 5 is equal to "Department".
        Assert.assertEquals("Department", getHeadersText(5));
        // Step 9 : Assert that the header text at index 6 is equal to "Action".
        Assert.assertEquals("Action", getHeadersText(6));

    }

/*
TC02: Verify data
Step 1 : Navigate to the URL "https://demoqa.com/webtables".
Step 2: Verify data for Cierra Vega
Step 3: Verify data for Alden Cantrell
Step 4: Verify data for Kierra Gentry
 */


    @Test
    public void verifyEmployeeFirstRowData() {
        // Step 1 : Navigate to the URL "https://demoqa.com/webtables".
        driver.get("https://demoqa.com/webtables");
        //  Step 2: Verify data for Cierra Vega
        verifyEmployeeDataText("Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance");

        //  Step 3: Verify data for Alden Cantrell
        //  verifyEmployeeDataText("Alden","Cantrell","45","alden@example.com","12000","Compliance") ;

        //  Step 4: Verify data for Kierra Gentry
        //  verifyEmployeeDataText("Kierra","Gentry","29","kierra@example.com","2000","Legal") ;

    }

    @Test
    public void verifyEmployeeDataSecondRow() {
        // Step 1 : Navigate to the URL "https://demoqa.com/webtables".
        driver.get("https://demoqa.com/webtables");
        //  Step 3: Verify data for Alden Cantrell
        verifyEmployeeDataText("Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance");

        //  Step 4: Verify data for Kierra Gentry
        //  verifyEmployeeDataText("Kierra","Gentry","29","kierra@example.com","2000","Legal") ;

    }


/*
    TC03: Number of Rows Test
    Step 1: Navigate to the "https://demoqa.com/webtables" URL.
    Step 2: Identify the dropdown element for selecting the number of rows per page.
    Step 3: Click on the "listNumberofRows" dropdown to expand the options.
    Step 4: Identify the first option in the dropdown with a value of '5'.
    Step 5: Click on the "firstOption5rows" option to select it.
    Step 6: Call the "numberOfRows()" method and store the returned value in a variable named "actualNumberOfRows".
    Step 7: Assert that the "actualNumberOfRows" variable is equal to 5.
     */


    @Test
    public void numberOfRowsTest() {
        // Step 1 : Navigate to the URL "https://demoqa.com/webtables".
        driver.get("https://demoqa.com/webtables");
        // Step 3: Click on the "listNumberofRows" dropdown to expand the options.
        listOfNumberRowsClick();
        // Step 5: Click on the "firstOption5rows" option to select it.
        rowsDropDownListClick(20) ;
        // Step 6: Call the "numberOfRows()" method and store the returned value in a variable named "actualNumberOfRows".
        int actualNumberofRows = numberOfRows() ;
        // Step 7: Assert that the "actualNumberOfRows" variable is equal to 5.

        Assert.assertEquals(20,actualNumberofRows);
        Assert.assertEquals(20,numberOfRows());
    }



}
