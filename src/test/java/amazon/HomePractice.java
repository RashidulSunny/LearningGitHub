package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePractice {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void testMethod(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//1. Title
    String ExpectedResult = "Amazon.com. Spend less. Smile more.";
    String ActualResult = driver.getTitle();
    Assert.assertEquals(ActualResult,ExpectedResult);


//2.  Sign In

        driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sunny09203019@gmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Babuiii$1382020$");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

//3. searchIcon
      driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");
      WebElement searchIcon = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
      searchIcon.click();

//4. search home and entertain
        driver.findElement(By.xpath("//button[contains(text(),'Home & Entertainment')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Apple MacBooks')]")).click();
        driver.findElement(By.xpath("//span[@class ='a-button-text a-declarative']")).click();
        driver.findElement(By.xpath("//a[@id = 's-result-sort-select_2']")).click();

//5. put tp cart

        driver.findElement(By.xpath("//span[contains(text(),'Apple MacBook Pro 13.3 Laptop Intel Core i5 1.4GHz 8GB RAM 256GB SSD MUHR2LL/A (Renewed)')]")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        //driver.findElement(By.xpath("//span[@id ='attachSiAddCoverage-announce']")).click();






        

    }

    @AfterMethod
    public void afterMethod(){
        //driver.quit();
    }



}
