package automation_test.mortgage_calculator_parametarized;

import org.testng.annotations.Test;
import page_objects.NavigationBar;
import automation_test.mortgage_calculator.BaseClass;
import utilities.DateUtils;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CalculateMortgageRateParameterized  extends BaseClass {
   // private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);

    @Test
    public void calculateMonthlyPayment() {
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
           //LOGGER.error(e.getMessage());
       }

    }

}
