import common.LoanAppHelper;
import dataprovider.CustomerDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.AddCustomersPage;
import pageobject.CustomersPage;
import pageobject.HomePage;

public class Customers {

    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)

    public void AddCustomer1 (String branch, String branchAdmin, String branchPassword, String firstname, String lastname, String warning){

        //Set Gecko.driver property to interact to Firefox browser
        System.setProperty("webdriver.gecko.driver","C://Program Files/geckodriver.exe");

        // Create a new instance of Firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        Login login = new Login();

        HomePage homePage = new HomePage(driver);
        CustomersPage customersPage = new CustomersPage(driver);
        AddCustomersPage addCustomerPage = new AddCustomersPage(driver);

        LoanAppHelper loanAppHelper =new LoanAppHelper();

        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // Try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click button 'Customers'
        loanAppHelper.clickElementByID(driver, "ext-gen192");

        // click button 'Actions'
        loanAppHelper.clickElementByXPath(driver, "//td[1]/table/tbody/tr/td[2]/em/button");

        // Try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click menu item 'Add Customer' link
        loanAppHelper.clickElementByLinkName(driver, "Add Customer");

        // Enter First Name
        loanAppHelper.setText(driver, "FirstName", firstname);

        // Enter Last Name
        loanAppHelper.setText(driver, "LastName", lastname);

        // Click button 'Save'
        loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {

            // verify the proper warning message text
            loanAppHelper.doesTextExistOnPage(driver, warning);

            // click ok button to close pop up
            loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");

            // Click button 'Cancel'
            loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");

        } else {

            // verify the results by parsing html page and making sure it contain just created first name
            loanAppHelper.doesTextExistOnPage(driver, firstname);

        }

       // Click button 'Logout'
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

       // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }

}




//    public void AddCustomer (String branch, String branchAdmin, String branchPassword, String firstname, String lastname, String warning){
//
//        //Set Gecko.driver property to interact to Firefox browser
//        System.setProperty("webdriver.gecko.driver","C://Program Files/geckodriver.exe");
//
//        // Create a new instance of Firefox driver
//        WebDriver driver = new FirefoxDriver();// Create instance of class Login to use its LMSLogin method in our Add Customer scenario

//        int numberOFMilliseconds = 5000;
//
//        Login login = new Login();
//
//        HomePage homePage = new HomePage(driver);
//        CustomersPage customersPage = new CustomersPage(driver);
//        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
//
//        LoanAppHelper loanAppHelper =new LoanAppHelper();
//
//        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
//        login.LMSLogin(driver, branch, branchAdmin, branchPassword);
//
//        // Try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // Find button 'Customers' by its id
//        WebElement element = driver.findElement(By.id("ext-gen192"));
//
//        // Click button 'Customers'
//        homePage.clickCustomersButton(driver);
//
//        // Find button 'Actions' by its id
//        element = driver.findElement(By.xpath("//td[1]/table/tbody/tr/td[2]/em/button"));
//
//        // click button 'Actions'
//        customersPage.clickActionsButton(driver);
//
//        // Try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // Find menu item 'Add Customer' by link text
//        element = driver.findElement(By.linkText("Add Customer"));
//
//        // Click menu item 'Add Customer'
//        customersPage.clickAddCustomerLink(driver);
//
//        // Find the text input element 'First Name' by its name
//        element = driver.findElement(By.name("FirstName"));
//
//        // Enter First Name
//        addCustomerPage.setFirstName(driver, firstname);
//
//        // Find the text input element 'Last Name' by its name
//        element = driver.findElement(By.name("LastName"));
//
//        // Enter Last Name
//        addCustomerPage.setLastName(driver, lastname);
//
//        // Find button 'Save' by its xpath
//        element = driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button"));
//
//        // Click button 'Save'
//        addCustomerPage.clickSaveButton(driver);
//
//        // try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        if (warning != "") {
//
//            // verify the proper warning message text
//            loanAppHelper.doesTextExistOnPage(driver, warning);
//
//            // click ok button to close pop up
//            addCustomerPage.clickOKButton(driver);
//
//            // Find button 'Cancel' by its xpath
//            element = driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button"));
//
//            // Click button 'Cancel'
//            addCustomerPage.clickCancelButton(driver);
//
//        } else {
//
//            // verify the results by parsing html page and making sure it contain just created first name
//            loanAppHelper.doesTextExistOnPage(driver, first name);
//
//        }
//
//       // Find button 'Logout' by its xpath
//        element = driver.findElement(By.xpath("//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button"));
//
//       // Click button 'Logout'
//        customersPage.clickLogoutButton(driver);
//
//       // try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // close the browser
//        driver.close();
//    }
