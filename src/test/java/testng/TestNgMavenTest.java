package testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.DateUtils;
import utilities.ReadConfigFiles;

public class TestNgMavenTest {
   private static final Logger LOGGER = LogManager.getLogger(TestNgMavenTest.class);
    //@Test
    public void run(){
       LOGGER.debug("This is debug message");
       LOGGER.info("This is info message");
       LOGGER.warn("This is warning message");
       LOGGER.error("This is error message");
       LOGGER.fatal("This is very dangerous");
       LOGGER.trace("General Information");

    }
    @Test
    //public void testPropertyFile(){
        //LOGGER.info(ReadConfigFiles.getPropertyValues("DbUser"));
    public void date(){
        System.out.println(DateUtils.returnNextMonth());

    }
}
