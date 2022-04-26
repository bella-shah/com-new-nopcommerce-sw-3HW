package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void Setup() {
        openBrowser(baseUrl);
    }

    @Test

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
    //	1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
        String expectedTabText=menu;
        String actualTabText=getTextFromElement(By.tagName("h1"));
        Assert.assertEquals("Link not Working", expectedTabText,actualTabText);

    }
    @Test
    //	1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    public void verifyPageNavigation(){
        selectMenu("Computer");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital download");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }
    @After
    //close Browser
    public void tearDemo(){

    }

}
