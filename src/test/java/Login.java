import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class Login {

    @Test
    //public void LMSLogin(WebDriver driver) {
    public void LMSLogin(WebDriver driver, String branch, String branchAdmin, String branchPassword) {

        //Set Gecko.driver property to interact to Firefox browser
        System.setProperty("webdriver.gecko.driver","C://Program Files/geckodriver.exe");

        //Create Objects required for this test
        LoginPage loginPage = new LoginPage(driver);

// Create a new instance of Firefox driver
//WebDriver driver = new FirefoxDriver();

// And now use this to visit LMS login page
        driver.get("http://test-hitekschool.com/lms/loans/2107");

// Maximize window
        driver.manage().window().maximize();

// Read the title of the page and output it into results
        System.out.println("Page title is: " + driver.getTitle());

// Find the text input element 'branch' by its name
       // WebElement element = driver.findElement(By.name("j_branch"));

// Enter branch name
        //element.sendKeys(branch);

// Find the text input element 'username' by its name
        //element = driver.findElement(By.name("j_username"));

// Enter username
        //((WebElement) element).sendKeys(branchAdmin);

// Find the text input element 'password' by its name
        //element = driver.findElement(By.name("j_password"));

// Enter password
        //element.sendKeys(branchPassword);

// Find the button Login by its id
        //element = driver.findElement(By.id("ext-gen38"));

// Click Login button
        //element.click();

        // Enter branch name
        loginPage.setBranchName (driver, branch);

// Enter branch admin username
        loginPage.setBranchAdminUsername(driver, branchAdmin);

// Enter branch admin password
        loginPage.setBranchAdminPassword(driver, branchPassword);

// Click Login button
        loginPage.clickLoginButton(driver);

// Try to sleep (wait) for 10 sec (using exception handler)
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Read the title of the page and output it into results - need it for debug purpose
        System.out.println("Page title is: " + driver.getTitle());

// Verify the title of the page
        //Assert.assertEquals(driver.getTitle(), "Loan Management System - 'Paris' branch");
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branch + "' branch");

// Close the browser
 //driver.close();

    }
}