package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgWebDriver {
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");

    }
    @Test
    public void verifyHomePageTitle(){


        String expectedTitle = "Demo Script Test drive - PHPTRAVELS";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @AfterMethod
    public void closeBrowser(){

        driver.quit();

    }
}
