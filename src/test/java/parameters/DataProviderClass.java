package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object [][] storeStringValues(){
        return new Object[][]{
                {"Sunny"},
                {"Razu"},
                {"Asif"},
                {"Parvez"},
                {"Anika"},
                {"Jenica"}
        };
    }
    @DataProvider(name = "MultipleValues")
    public Object [][] storeMultipleValues() {
        return new Object[][]{
                {"Sunny", "New York", 11365},
                {"Razu", "Brooklyn", 11456},
                {"Asif", "Queens", 11423},
                {"Parvez", "Pennsylvania", 33245},
                {"Anika", "Jamaica", 11432},
                {"Jenica", "Verena", 45632}

        };
    }
        @DataProvider(name = "RealAprRates")
                public Object [][] storeRealAprRatesData(){
            return new Object[][]{
                    {"200000", "15000", "3", "30", "1", "0", "1200", "3.139%"}
            };
        }


    @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name){
        System.out.println("[Single Column Value] name is: " + name);
    }
    @Test(dataProvider = "MultipleValues")
    public void readMultipleValue(String name, String state, int zipCode){
        System.out.println("[Multiple Column Value] name is: " + name);
        System.out.println("[Multiple Column Value] state is: " + state);
        System.out.println("[Multiple Column Value] zipcode is: " + zipCode);
    }
}
