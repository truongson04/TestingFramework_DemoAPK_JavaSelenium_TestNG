package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
    private static ExtentReports extentReports;

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public synchronized static ExtentReports initExtentReport() {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("Appium Automation Report");
            sparkReporter.config().setReportName("Mobile Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);


        }
        return extentReports;
    }

    public static synchronized void createTest(String testName) {
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
        extentTest.remove();
    }
}