package command_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementAssertions {
    WebDriver driver;
    private By locator;
    public ElementAssertions(WebDriver driver,By locator){
        this.driver = driver;
        this.locator = locator;

    }
    //create assertion (boolean condition) for element display
    public ElementAssertions elementDisplayed(){
        boolean display = driver.findElement(locator).isDisplayed();
        Assert.assertTrue(display,"The Expected result does not displayed");
        return this;

    }
    //create assertion (boolean condition) for element clickable/enable for click
    public ElementAssertions elementClickable(){
        boolean enable = driver.findElement(locator).isEnabled();
        Assert.assertTrue(enable,"The Expected result does not clickable");
        return this;
    }


}
