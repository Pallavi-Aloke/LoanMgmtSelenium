package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoanAppHelper {


    public boolean doesTextExistOnPage(WebDriver driver, String textToLookFor) {
        WebElement body = driver.findElement(By.tagName("body"));
        return body.getText().contains(textToLookFor);
    }


    public void sleep(int numberOfMilliseconds) {
        try {
            Thread.sleep(numberOfMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickElementByXPath(WebDriver driver, String xpath) {
        // find element
        WebElement element = driver.findElement(By.xpath(xpath));

        // click element
        element.click();
    }


    public void clickElementByLinkName(WebDriver driver, String name) {
        // find element
        WebElement element = driver.findElement(By.linkText(name));

        // click element
        element.click();
    }


    public void clickElementByID(WebDriver driver, String id) {
        // find element
        WebElement element = driver.findElement(By.id(id));

        // click element
        element.click();
    }


    public void setText (WebDriver driver, String name, String text ) {
        // find element
        WebElement element = driver.findElement(By.name(name));

        // Type text
        element.sendKeys(text);
    }


    public void selectItem (WebDriver driver, String id, String item){
        // find element
        WebElement element = driver.findElement(By.id(id));

        // Create select object
        Select select = new Select(element);

        // Select item
        select.selectByVisibleText(item);

    }


}
