package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    //make it private, so it will not allow to create an object outside of this class. only create object in this class
    public DriverFactory(){
        //Empty Constructor
    }
    //create object
    public static final DriverFactory instance = new DriverFactory();
    //create a method
    public static DriverFactory getInstance(){
        return instance;
    }
    //create lambda expression using ThreadLocal which allow driver object to initialize chromedriver
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() ->{
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    });
    public WebDriver getDriver(){
        return driver.get();
    }
    //for kill driver end of the execution
    public void removeDriver(){
        driver.get().quit();
        driver.remove();

    }

}
