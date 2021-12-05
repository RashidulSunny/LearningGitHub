package playground;

import org.testng.annotations.Test;
import parameters.DataProviderClass;

public class ExecuteTest {
    @Test(dataProvider = "MultipleValues", dataProviderClass = DataProviderClass.class)
    public void run(String name, String state, int zipCode){
        System.out.println("[Multiple Column Value] name is: " + name);
        System.out.println("[Multiple Column Value] state is: " + state);
        System.out.println("[Multiple Column Value] zipcode is: " + zipCode);
    }


}
