package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    // this is a constructor
    public UsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // LOCATORS

    // button 'Actions'
    @FindBy(how = How.XPATH, using = "//td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonActions;

    // link 'Add User'
    @FindBy(how = How.LINK_TEXT, using = "Add User")
    private WebElement linkAddUser;

    // link 'Edit User'
    @FindBy(how = How.LINK_TEXT, using = "Edit User")
    private WebElement linkEditUser;

    // link 'Delete User'
    @FindBy(how = How.LINK_TEXT, using = "Delete User")
    private WebElement linkDeleteUser;

    // button 'Logout'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonLogout;



    // METHODS

    public UsersPage clickActionsButton (WebDriver driver) {
        // click Users button
        buttonActions.click();
        return this;
    }
    public UsersPage clickAddUserLink (WebDriver driver) {
        // click Add User link
        linkAddUser.click();
        return this;
    }
    public UsersPage clickEditUserLink (WebDriver driver) {
        // click Edit User link
        linkEditUser.click();
        return this;
    }
    public UsersPage clickDeleteUserLink (WebDriver driver) {
        // click Delete User link
        linkDeleteUser.click();
        return this;
    }
    public UsersPage clickLogoutButton (WebDriver driver) {
        // click Logout button
        buttonLogout.click();
        return this;
    }

}
