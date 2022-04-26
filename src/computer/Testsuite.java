package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class Testsuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testName() throws InterruptedException {
        //1.1 Click on Computer Menu.
        mouseHoverOnly(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on Desktop
        mouseHoverClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        verifyText("Name: Z to A", getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]")), "Error, Message not displayed");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //	2.1 Click on Computer Menu.
        mouseHoverOnly(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //	2.2 Click on Desktop
        mouseHoverClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //	2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        //2.4 Click on "Add To Cart"
        sendTextToElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"), Keys.ENTER + "1");
        //  //	2.5 Verify the Text "Build your own computer"
        verifyText("Build your own computer", getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")), "Error, Message not displayed");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //	2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // 2.10 Check Two Check boxes "Microsoft Office []" and "Total Commander []"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //	2.11 Verify the price "$1,475.00"
        verifyText("$1,475.00", getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "Incorrect price!");
        // 2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("shopping cart", getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]")), "Incorrect Message");
        //After that close the bar clicking on the cross button
        clickOnElement(By.className("close"));
        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        //	2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Incorrect page");
        //	2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.xpath("(//input[contains(@id, 'itemquantity')])"), Keys.BACK_SPACE + "2");
        clickOnElement(By.xpath("//button[text()='Update shopping cart']"));
        //2.17 Verify the Total"$2,950.00"
        verifyText("$2,940.00", getTextFromElement(By.className("product-subtotal")), "Incorrect price");
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //	2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //	2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")), "Error");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Bella");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Shah");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "shahbella55@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "159 Ealing Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HP20 1DA");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07593876523");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='billing-buttons-container']/button[4]"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        //2.28 Fill all the details
        clickOnElement(By.xpath("//*[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//*[@id='payment-method-buttons-container']/button"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Bella Shah");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5555 5555 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "03");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "132");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")), "Incorrect payment method");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Next Day Air", getTextFromElement(By.xpath("//*[@id=\"shipping-methods-form\"]/ul/li[2]/div[1]') and @class='value']")), "Incorrect Shipping method");
        //	2.33 Verify Total is “$2,950.00”
        verifyText("$2,950.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")), "Error");
        //	2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
        //	2.35 Verify the Text “Thank You
        verifyText("Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")), "Incorrect Message");
        //	2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Incorrect page");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}






