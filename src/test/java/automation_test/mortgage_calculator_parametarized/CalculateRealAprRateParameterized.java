package automation_test.mortgage_calculator_parametarized;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import parameters.DataProviderClass;
import automation_test.mortgage_calculator.BaseClass;

public class CalculateRealAprRateParameterized  extends BaseClass {
   // private static final Logger LOGGER = LogManager.getLogger(CalculateRealAprRateParameterized.class);


    @Test(dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
    public void calculateActualApr(String homePriceField, String downPaymentField, String interestRateField, String lengthField, String discountPointsField, String loanFeesField, String closingCostField, String realAprRate ){
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

}
