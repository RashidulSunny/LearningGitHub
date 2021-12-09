package automation_test.mortgage_calculator;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;



public class CalculateMortgageRate extends BaseClass {

    @Test//(retryAnalyzer = RetryFailedTests.class)
    public void calculateMonthlyPayment(){
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

}
