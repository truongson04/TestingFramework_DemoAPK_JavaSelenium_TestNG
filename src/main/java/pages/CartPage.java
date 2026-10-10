package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private By totalPrice = AppiumBy.accessibilityId("total price"); //
    private By productPrice = AppiumBy.accessibilityId("product price");
    private By quantity = AppiumBy.androidUIAutomator("new UiSelector().text(\"3\").instance(1)");
    private By proceedBtn = AppiumBy.accessibilityId("Proceed To Checkout button");
    public By getTotalPrice(){
        return totalPrice;
    }
    public By getProductPrice(){
        return productPrice;
    }
    public By getQuantity(){
        return quantity;
    }
    public void clickProceed(){
        clickElement(proceedBtn);
    }
}

