package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static AppiumDriver createDriver(String platformName){
        AppiumDriver driver=null;
        try {
            if(platformName.equalsIgnoreCase("Android")){
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setDeviceName("My phone");
                options.setAppPackage("com.saucelabs.mydemoapp.rn");
                options.setUdid("emulator-5554");
                options.setAppActivity(".MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            }
        }
       catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
      return  driver;
    }
}
