package Listeners;

import driver.DriverManager;
import utils.ReportManager;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ReportManager.initExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AppiumDriver driver = DriverManager.getDriver();

        ReportManager.getTest().pass("Test Passed");
        if (driver != null) {

            saveScreenshotForAllure(driver);


            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ReportManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Screenshot on Failure");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AppiumDriver driver = DriverManager.getDriver();

        ReportManager.getTest().fail(result.getThrowable());

        if (driver != null) {

            saveScreenshotForAllure(driver);


            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ReportManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Screenshot on Failure");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getTest().skip("Test Skipped");
        ReportManager.getTest().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        ReportManager.flushReport();
    }


    @Attachment(value = "Page Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotForAllure(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}