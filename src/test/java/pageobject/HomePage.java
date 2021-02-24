package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }
// LOCATORS

    // button 'Users'
    @FindBy(how = How.ID, using = "ext-gen185")
    private WebElement buttonUsers;

    // button 'Customers'
    @FindBy(how = How.ID, using = "ext-gen192")
    private WebElement buttonCustomers;

    // METHODS
    public HomePage clickUsersButton (WebDriver driver) {

// click Users button
        buttonUsers.click();
        return this;

    }

    public HomePage clickCustomersButton (WebDriver driver) {

// click Customers button
        buttonCustomers.click();
        return this;

    }

}
