package automation_test.mortgage_calculator;

import command_provider.ActOn;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;


public class CalculateMortgageRate {
    WebDriver driver;


    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @Test
    private void calculateMonthlyPayment(){
        String date = DateUtils.returnNextMonth();
        String [] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPaymentPrice("60000")
                .clickDollarCheckBox()
                .typeLoanAmount("240000").typeInterestRate("3")
                .typeLoanTerm("30")
                .selectMonthCheckBox(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmiValue("0.5")
                .typeHomeInsurance("1000")
                .typeMonthlyHoa("100")
                .selectLoanType("FHA")
                .selectBuy("Buy")
                .clickCalculateButton().validateTotalMonthlyPayment("$1,611.85");

    }
   @AfterMethod
    private void browserClose(){
        ActOn.browser(driver).closeBrowser();
    }




}
