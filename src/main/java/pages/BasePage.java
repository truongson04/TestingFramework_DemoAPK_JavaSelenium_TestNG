package pages;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {
 protected AppiumDriver getDriver(){
     return DriverManager.getDriver();
 }
 protected WebElement waitForElementVisible(By locator){
     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
     return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 }
 protected  WebElement waitForClickable(By locator){
     WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
     return wait.until(ExpectedConditions.elementToBeClickable(locator));
 }
 protected void clickElement(By locator){
     WebElement element= waitForClickable(locator);
     sleep(2);
     element.click();
 }
 protected  void inputElement(By locator, String text){
     WebElement element = waitForElementVisible(locator);
     element.clear();
     sleep(2);
     element.sendKeys(text);
 }
 protected  void goTo(By locator){
     WebElement element = waitForClickable(locator);
     sleep(2);
     element.click();
 }
 protected void sleep(double second){
     try {
         Thread.sleep((long) second *1000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
 }
 public boolean isElementDisplayed(By locator){
     WebElement element = waitForElementVisible(locator);
     return element.isDisplayed();

 }
 public   String getElementText(By locator){
     WebElement element = waitForElementVisible(locator);
     return element.getText();
 }
public  boolean isElementSelected(By locator){
     WebElement element = waitForClickable(locator);
     return element.isSelected();
}
protected void clickWhenVisible(By locator){
     WebElement element = waitForElementVisible(locator);
     element.click();
}



}
