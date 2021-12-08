package automation_test.mortgage_calculator;

import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;
import utilities.ReadConfigFiles;

public class BaseClass {
    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("-------Test: %s----------",this.getClass().getName());
    String endTestCase = String.format("----------Test End: %s--------",this.getClass().getName());
    @BeforeClass
    public void addThread(){
        ThreadContext.put("threadName",this.getClass().getName());
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver = DriverFactory.getInstance().getDriver();
    }

    @BeforeMethod
    public void browserInitialization(){
        LOGGER.info(testCaseName);
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    @BeforeMethod
    public void browserInitializationParameterized(){
        //LOGGER.info("---------------Test Name: Calculate Real APR Rate---------------");
        String browserUrl =  ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);

    }


    @AfterMethod
    public void browserClose() {
//        ActOn.browser(driver).closeBrowser();
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(endTestCase);
    }
//    @AfterMethod
//    public void browserCloseParameterized(){
//        //LOGGER.info("---------End Test Case: Calculate Real APR");
//
//        ActOn.browser(driver).closeBrowser();
//    }


}
