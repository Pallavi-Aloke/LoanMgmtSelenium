package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }


// LOCATORS

    // text field 'branch name'
    @FindBy(how = How.NAME, using = "j_branch")
    private WebElement branchName;

    // text field 'branch admin username'
    @FindBy(how = How.NAME, using = "j_username")
    private WebElement branchAdminUsername;

    // text field 'branch name'
    @FindBy(how = How.NAME, using = "j_password")
    private WebElement branchAdminPassword;

    // button 'Login'
    @FindBy(how = How.ID, using = "ext-gen38")
    private WebElement buttonLogin;

// METHODS

    public LoginPage setBranchName (WebDriver driver, String branch ) {

// Find the text input element 'branch' by its name
        //WebElement element = driver.findElement(By.name("j_branch"));
        branchName.sendKeys(branch);
        return this;

    }

// Enter username
        //element.sendKeys(branch);

       // return this;

    //}

    public LoginPage setBranchAdminUsername (WebDriver driver,String branchAdmin) {

// Find the text input element 'username' by its name
        //WebElement element = driver.findElement(By.name("j_username"));

// Enter username
        //element.sendKeys(branchAdmin);
        branchAdminUsername.sendKeys(branchAdmin);

        return this;

    }

    public LoginPage setBranchAdminPassword (WebDriver driver, String branchPassword) {

// Find the text input element 'password' by its name
        //WebElement element = driver.findElement(By.name("j_password"));

// Enter password
        //element.sendKeys(branchPassword);
        branchAdminPassword.sendKeys(branchPassword);

        return this;

    }

    public LoginPage clickLoginButton (WebDriver driver) {

// Find the button Login by its id
        //WebElement element = driver.findElement(By.id("ext-gen38"));

// click Login button
        //element.click();
        buttonLogin.click();

        return this;

    }

}
