package base;

import driver.DriverFactory;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters({"platformName"})
    @BeforeMethod
    public void setUp(String platformName){
        AppiumDriver newDriver = DriverFactory.createDriver(platformName);
        DriverManager.setDriver(newDriver);

    }
    @AfterMethod
    public  void teardown(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.removeDriver();
        }
    }
}
