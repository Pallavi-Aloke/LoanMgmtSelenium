import common.LoanAppHelper;
import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.UsersPage;

import static java.lang.Thread.sleep;

public class Users {

    //@Test
    //@Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    //@Parameters(value= {"branch", "branchAdmin", "branchPassword", "user", "password"})
    //public void AddUser() {
    //public void AddUser(String branch, String branchAdmin, String branchPassword, String user, String password) {

    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)

    public void AddUser1(String branch, String branchAdmin, String branchPassword, String user, String password, String warning) {

        //Set Gecko.driver property to interact to Firefox browser
        System.setProperty("webdriver.gecko.driver", "C://Program Files/geckodriver.exe");

        // Create a new instance of Firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        //Create Objects required for this test
        Login login = new Login();

        HomePage homePage = new HomePage(driver);
        UsersPage usersPage = new UsersPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);
        LoanAppHelper loanAppHelper = new LoanAppHelper();

        //login.LMSLogin(driver);
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // Try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click button 'Users'
        loanAppHelper.clickElementByID(driver, "ext-gen185");

        // Click button 'Actions'
        loanAppHelper.clickElementByXPath(driver, "//td[1]/table/tbody/tr/td[2]/em/button");
        ;

        // Try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click 'Add User' link
        loanAppHelper.clickElementByLinkName(driver, "Add User");

        // Enter 'Username'
        loanAppHelper.setText(driver, "Username", user);

        // Enter 'Password'
        loanAppHelper.setText(driver, "Password", password);

        // Click button 'Save'
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {

            // verify the proper warning message text
            loanAppHelper.doesTextExistOnPage(driver, warning);

            // click ok button to close pop up
            loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");

            // click button 'Cancel'
            loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");

        } else {

            // verify the results by parsing html page and making sure it contain just created username
            loanAppHelper.doesTextExistOnPage(driver, user);

        }

        // Click button 'Logout'
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }
}

//    public void AddUser (String branch, String branchAdmin, String branchPassword, String user, String password, String warning){
//
//        //Set Gecko.driver property to interact to Firefox browser
//       System.setProperty("webdriver.gecko.driver","C://Program Files/geckodriver.exe");
//
//        // Create a new instance of Firefox driver
//        //WebDriver driver = new FirefoxDriver();
//
//        // Create instance of class login to use its LMSLogin method in our Add User scenario
//        //Login login = new Login();
//
//        // Create a new instance of Firefox driver
//        WebDriver driver = new FirefoxDriver();// Create instance of class Login to use its LMSLogin method in our Add User scenario
//
//        int numberOFMilliseconds = 5000;
//
//        Login login = new Login();
//
//        HomePage homePage = new HomePage(driver);
//        UsersPage usersPage = new UsersPage(driver);
//        AddUserPage addUserPage = new AddUserPage(driver);
//
//        LoanAppHelper loanAppHelper =new LoanAppHelper();
//
//        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
//        //login.LMSLogin(driver);
//        login.LMSLogin(driver, branch, branchAdmin, branchPassword);
//
//        // Try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // Find button 'Users' by its id
//        //WebElement element = driver.findElement(By.id("ext-gen185"));
//
//        // Click button 'Users'
//        //element.click();
//        homePage.clickUsersButton(driver);
//
//        // Find button 'Actions' by its id
//        //element = driver.findElement(By.xpath("//td[1]/table/tbody/tr/td[2]/em/button"));
//
//        // click button 'Actions'
//        //element.click();
//        usersPage.clickActionsButton(driver);
//
//        // Try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // Find menu item 'Add User' by link text
//        //element = driver.findElement(By.linkText("Add User"));
//
//        // Click menu item 'Add User'
//        //element.click();
//        usersPage.clickAddUserLink(driver);
//
//        // Find the text input element 'username' by its name
//        //element = driver.findElement(By.name("Username"));
//
//        // Enter username
//        //element.sendKeys("bmoriott");
//        //element.sendKeys(user);
//        addUserPage.setUsername(driver, user);
//
//        // Find the text input element 'password' by its name
//        //element = driver.findElement(By.name("Password"));
//
//        // Enter password
//        //element.sendKeys("password01");
//        //element.sendKeys(password);
//        addUserPage.setPassword(driver, password);
//
//        // Find button 'Save' by its xpath
//        //element = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button"));
//
//        // Click button 'Save'
//        //element.click();
//        addUserPage.clickSaveButton(driver);
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
//            //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")).click();
//            addUserPage.clickOKButton(driver);
//
//            // Find button 'Cancel' by its xpath
//            //element = driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button"));
//
//            // Click button 'Cancel'
//            //element.click();
//            addUserPage.clickCancelButton(driver);
//
//        } else {
//
//            // verify the results by parsing html page and making sure it contain just created username
//            loanAppHelper.doesTextExistOnPage(driver, user);
//
//        }
//
//       // Find button 'Logout' by its xpath
//        //element = driver.findElement(By.xpath("//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button"));
//
//       // Click button 'Logout'
//        //element.click();
//        usersPage.clickLogoutButton(driver);
//
//       // try to sleep (wait) for 5 sec (using exception handler)
//        loanAppHelper.sleep(numberOFMilliseconds);
//
//        // close the browser
//        driver.close();
//    }