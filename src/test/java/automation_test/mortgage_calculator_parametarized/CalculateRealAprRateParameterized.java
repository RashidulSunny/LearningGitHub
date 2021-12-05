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
import parameters.DataProviderClass;
import utilities.ReadConfigFiles;

public class CalculateRealAprRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRealAprRateParameterized.class);

    WebDriver driver;

    @BeforeMethod
    private void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name: Calculate Real APR Rate---------------");

        String browserUrl =  ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);

    }

    @Test(dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
    private void calculateActualApr(String homePriceField, String downPaymentField, String interestRateField, String lengthField, String discountPointsField, String loanFeesField, String closingCostField, String realAprRate ){
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePriceField(homePriceField)
                .selectDollarSign()
                .typeDownPaymentField(downPaymentField)
                .typeInterestRateField(interestRateField)
                .typeLengthField(lengthField)
                .typeDiscountPointsField(discountPointsField)
                .typeLoanFeesField(loanFeesField)
                .typeClosingCostField(closingCostField)
                .clickCalculateButton()
                .validateActualAprRate(realAprRate);

    }

    @AfterMethod
    private void browserClose(){
        LOGGER.info("---------End Test Case: Calculate Real APR");

        ActOn.browser(driver).closeBrowser();
    }

}
