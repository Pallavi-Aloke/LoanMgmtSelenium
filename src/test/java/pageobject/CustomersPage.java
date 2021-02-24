package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    // this is a constructor
    public CustomersPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    // LOCATORS

    // button 'Actions'
    @FindBy(how = How.XPATH, using = "//td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonActions;

    // link 'Add customer'
    @FindBy(how = How.LINK_TEXT, using = "Add Customer")
    private WebElement linkAddCustomer;

    // link 'Edit Customer'
    @FindBy(how = How.LINK_TEXT, using = "Edit Customer")
    private WebElement linkEditCustomer;

    // link 'Delete Customer'
    @FindBy(how = How.LINK_TEXT, using = "Delete Customer")
    private WebElement linkDeleteCustomer;

    // button 'Logout'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonLogout;



    // METHODS

    public CustomersPage clickActionsButton (WebDriver driver) {
        // click Customers button
        buttonActions.click();
        return this;
    }
    public CustomersPage clickAddCustomerLink (WebDriver driver) {
        // click Add Customer link
        linkAddCustomer.click();
        return this;
    }
    public CustomersPage clickEditCustomerLink (WebDriver driver) {
        // click Edit Customer link
        linkEditCustomer.click();
        return this;
    }
    public CustomersPage clickDeleteCustomerLink (WebDriver driver) {
        // click Delete Customer link
        linkDeleteCustomer.click();
        return this;
    }
    public CustomersPage clickLogoutButton (WebDriver driver) {
        // click Logout button
        buttonLogout.click();
        return this;
    }

}
