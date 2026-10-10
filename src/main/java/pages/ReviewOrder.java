package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReviewOrder extends BasePage {
    private By reviewproductPrice = AppiumBy.accessibilityId("product price");
    private By reviewQuantity = AppiumBy.accessibilityId("total number");
    private By reviewPrice = AppiumBy.accessibilityId("total price");
    private By placeOrderBtn = AppiumBy.accessibilityId("Place Order button");
    private By checkOutMessage = AppiumBy.androidUIAutomator("new UiSelector().text(\"Checkout Complete\")");

    public By getReviewPrice() {
        return reviewPrice;
    }

    public By getReviewQuantity() {
        return reviewQuantity;
    }

    public By getReviewproductPrice() {
        return reviewproductPrice;
    }
    public void clickPlaceOrder(){
        clickElement(placeOrderBtn);
    }

    public By getCheckOutMessage() {
        return checkOutMessage;
    }
}
