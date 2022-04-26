package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Utility extends BaseTest {
    //*********************************************Elements Method*********************************//
    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        // OR
        driver.findElement(by).click();
    }
    //This method will get text from element

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will send text to element

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will calculate size of List<WebElement>
    public int sizeOfListWebElement(By by) {
        List<WebElement> inventory = driver.findElements(by);
        int actualItems = inventory.size();
        return actualItems;
    }

    //This method will clear the text box
    public void clearTheTextBox(By by) {
        driver.findElement(by).clear();
    }

    //**************************************Alerts Methods***********************************//
    //this method is switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //this method is accepting the method
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method is for dismiss Alerts
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();

    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //------------------------------------------------select class methods ----------------------------//
    //sect by value, index ,visible text//This method will select the option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int indexNo) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNo);
    }

    //This method will select all options & choose 1 from all
    public void selectByAllOptions(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        //System.out.println("No. of Options:" + allOptions.size());
        for (WebElement element : allOptions) {
            System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
            }
        }
    }

    //***********************************************Switch Window Method*****************************************//
    //This method is for switching to iFrame
    public void switchIframe(By by, WebElement frameID, String text) {
        driver.switchTo().frame(frameID);
        sendTextToElement(by, text);
        driver.switchTo().defaultContent();
    }

    public void getParentWindowHandle(String parentWindow) {
        parentWindow = driver.getWindowHandle();
    }

    public void getBackToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

    public void getChildWindowHandles(String parentWindow) {
        parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for (String handle : handles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                clickOnElement(By.xpath("//a[contains(text(),'Sign In')]"));
                driver.close();
                break;
            }
        }
    }
    //****************************************Action Class Mouse perform Method***********************//

    public void mouseHoverClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    public void mouseHoverOnly(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).build().perform();
    }
    // OR

    //This method will be used to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //This method will be used to hover mouse on element & click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }


    //**************************************VerifyText method *********************************************//
    //verify method -1
    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

    //verify method -2
    public void messageValidation(String ExpMsg, String ActMsg) {
        Assert.assertEquals("Message is not as per Project Requirement:", ExpMsg, ActMsg);
    }

    //verify method -3
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    //*******************************************Click method for top Menu*****************************************//
    // this method click  on the menu whatever name is pass as a parameter
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    //*************************************************Select Radio button Method ************************************//
    public void setRadioElement(By by) {
        WebElement radioElement = driver.findElement(by);
        boolean selectState = radioElement.isSelected();
        if (selectState == false) {
            radioElement.click();
        }
        //***************************************************Random Email Method ***************************************//
    }

    public WebElement randomEmail1(By by) {
        WebElement emailtxt = driver.findElement(by);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailtxt.sendKeys("Savalia" + randomInt + "@gmail.com");
        return emailtxt;


    }

}



