package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 12.11.14
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class StylusSearchTest {
    WebDriver driver;

    @BeforeClass
    public void  browserSetUp()
    {
        //initialize a browser
        driver = new FirefoxDriver();
        //set wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        //maximize browser window for all element to be visible
        driver.manage().window().maximize();
        //get a url
        driver.get("https://google.com.ua/");
    }

     @Test
     public void searchSonyTest()
     {
         //find Google search field by id
         WebElement searchfieldG = driver.findElement(By.id("gbqfq"));
         //type url into search field
         searchfieldG.sendKeys("http://stylus.com.ua");
         //click "find" button
         driver.findElement(By.name("btnG")).click();
         //verify the result page
         Assert.assertEquals(driver.getCurrentUrl().contains("stylus.com.ua"), true );
         //find element with specified result
         WebElement stylusLink = driver.findElement(By.xpath("//a[contains(text(),'Stylus.com.ua')]"));
         //go to link
         stylusLink.click();

        //find Stylus search field
        WebElement searchFieldSt = driver.findElement(By.id("search_text"));
        // type device name into search field
        searchFieldSt.sendKeys("Sony Z2");
        //click find button
        driver.findElement(By.id("button")).click();
        // find link
        WebElement sonyLink = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a"));
        //verify
         Assert.assertEquals(sonyLink.getText().toString().contains("Sony Xperia Z2"), true);
         if(sonyLink.getText().toString().contains("Sony Xperia Z2"))
         {
             //go to Sony link
             sonyLink.click();
             //find "Характеристики" tab
             driver.findElement(By.xpath("//span[contains(text(),'Характеристики')]")).click();
             //find a section with "Интернет-доступ" info
             WebElement netAcces = driver.findElement(By.xpath("//td[preceding-sibling::td[contains(.,'Интернет-доступ')]]"));
             //verify  "Интернет-доступ"
             Assert.assertTrue(netAcces.getText().toString().contains("HTML, HTML5, Adobe Flash, RSS"));
         }
     }

    @AfterClass
    public void closeDown()
    {
        //close a browser
        driver.quit();
    }
}
