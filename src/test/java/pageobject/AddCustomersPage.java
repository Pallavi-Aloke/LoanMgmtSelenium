package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomersPage {

    // this is a constructor
    public AddCustomersPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    // LOCATORS

    // text field 'firstname'
    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement firstName;

    // text field 'lastname'
    @FindBy(how = How.NAME, using = "LastName")
    private WebElement lastName;

    // button 'Save'
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    // button 'Cancel'
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonCancel;

    // button 'OK' to close warning message
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")
    private WebElement buttonOK;


    // METHODS

    public AddCustomersPage setFirstName (WebDriver driver, String firstname ) {
        // Enter firstname
        firstName.sendKeys(firstname);
        return this;
    }
    public AddCustomersPage setLastName (WebDriver driver, String lastname ) {
        // Enter lastname
        lastName.sendKeys(lastname);
        return this;
    }
    public AddCustomersPage clickSaveButton (WebDriver driver) {
        // click Save button
        buttonSave.click();
        return this;
    }
    public AddCustomersPage clickCancelButton (WebDriver driver) {
        // click Cancel button
        buttonCancel.click();
        return this;
    }
    public AddCustomersPage clickOKButton (WebDriver driver) {
        // click OK  button on warning message pop up
        buttonOK.click();
        return this;
    }

}
