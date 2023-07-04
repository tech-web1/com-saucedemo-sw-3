package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username
       driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
       //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify the text Products
        String expectedText="Products text is display";
        String actualText=driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that six products are displayed
        List<WebElement>elements=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("Total product are"+elements.size());
        for (WebElement web :elements){
            System.out.println(web.getText());
        }
         int expectedSize=6;
         int actualSize= elements.size();
        Assert.assertEquals("Verify the product",expectedSize,actualSize);
    }






    @After
    public void tearDown(){
        closeBrowser();
    }
}