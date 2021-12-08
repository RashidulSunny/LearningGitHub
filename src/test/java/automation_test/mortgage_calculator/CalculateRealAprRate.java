package automation_test.mortgage_calculator;
import org.testng.annotations.Test;
import page_objects.NavigationBar;


public class CalculateRealAprRate extends BaseClass {

    @Test//(retryAnalyzer = RetryFailedTests.class)
    public void calculateActualApr(){
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

}
