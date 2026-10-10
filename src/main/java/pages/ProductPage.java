package pages;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class ProductPage extends  BasePage{
   private By sortIcon = AppiumBy.accessibilityId("sort button");
   private By priceDescending = AppiumBy.androidUIAutomator("new UiSelector().text(\"Price - Descending\")");
   private By lastCheapestItem = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Onesie\"]");


   public void selectTheLeastCheapestItem(){
        clickWhenVisible(sortIcon);
        clickWhenVisible(priceDescending);
        sleep(6);
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startY =(int) (size.getHeight()*0.9);
        int endY = (int) (size.getHeight()*0.1);
        int startX = (int)(size.getWidth()/2);
        swipeByXY(startX, startY, startX, endY);

        clickWhenVisible(lastCheapestItem);

    }
    public void swipeByXY(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction((finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY)));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(Collections.singletonList(swipe));
    }



}
