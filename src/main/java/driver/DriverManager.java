package driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private  static  ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public static AppiumDriver getDriver(){
        return driver.get();
    }
    public static void setDriver(AppiumDriver newDriver){
        driver.set(newDriver);

    }
    public static void removeDriver(){
        driver.remove();
    }
}
