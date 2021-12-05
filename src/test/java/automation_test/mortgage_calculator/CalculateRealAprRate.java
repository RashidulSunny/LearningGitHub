package automation_test.mortgage_calculator;

import command_provider.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAprRate {

    WebDriver driver;

    @BeforeMethod
    private void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");

    }

    @Test
    private void calculateActualApr(){
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePriceField("200000")
                .selectDollarSign()
                .typeDownPaymentField("15000")
                .typeInterestRateField("3")
                .typeLengthField("30")
                .typeDiscountPointsField("1")
                .typeLoanFeesField("0")
                .typeClosingCostField("1200")
                .clickCalculateButton()
                .validateActualAprRate("3.139%");

    }

    @AfterMethod
    private void browserClose(){

        ActOn.browser(driver).closeBrowser();
    }

}
