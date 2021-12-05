package automation_test.mortgage_calculator_parametarized;

import command_provider.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CalculateMortgageRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);
    WebDriver driver;


    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name: Calculate Monthly Payment---------------");

       String browserUrl =  ReadConfigFiles.getPropertyValues("Url");

        ActOn.browser(driver).openBrowser(browserUrl);


    }

    @Test
    private void calculateMonthlyPayment() {
        String date = DateUtils.returnNextMonth();
        String [] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];


       try{
           ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
           while (rs.next()){
               new NavigationBar(driver)
                       .navigateToHome()
                       .typeHomePrice(rs.getString("homevalue"))
                       .typeDownPaymentPrice(rs.getString("downpayment"))
                       .clickDollarCheckBox()
                       .typeLoanAmount(rs.getString("loanamount"))
                       .typeInterestRate(rs.getString("interestrate"))
                       .typeLoanTerm(rs.getString("loanterm"))
                       .selectMonthCheckBox(month)
                       .typeYear(year)
                       .typePropertyTax(rs.getString("propertytax"))
                       .typePmiValue(rs.getString("pmi"))
                       .typeHomeInsurance(rs.getString("homeownerinsurance"))
                       .typeMonthlyHoa(rs.getString("monthlyhoa"))
                       .selectLoanType(rs.getString("loantype"))
                       .selectBuy(rs.getString("buyorrefi"))
                       .clickCalculateButton()
                       .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));

           }

       }catch (SQLException e){
           LOGGER.error(e.getMessage());
       }

    }
   @AfterMethod
    private void browserClose(){
        LOGGER.info("---------End Test Case");
        ActOn.browser(driver).closeBrowser();
    }




}
