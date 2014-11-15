package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 07.11.14
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public class GoogleSearchTest {

   WebDriver driver;

    //Preconditions
    @BeforeClass
    public void setUp()
    {
        //Initialize a browser
        driver = new FirefoxDriver();
        //SEts implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Maximize a window size -  uvelichivaet okno brausera na ves ekran
        driver.manage().window().maximize();

        //Opens a url
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void searchTest()
    {

        //Finds an element by name
        WebElement searchfield = driver.findElement(By.name("q"));

        // Sends "Selenium" text into an input field
        searchfield.sendKeys("Selenium");

        // Finds first link with specified result
        WebElement seleniumlink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/li[1]/div/h3/a"));

        //Verifies a result
        Assert.assertEquals(seleniumlink.getText().toString().contains("Selenium"), true);
    }
        @AfterClass
        public void teraDown()
        {
            //Close a browser
            driver.quit();
        }
    }




