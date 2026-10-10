package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckOutExtra extends BasePage{
    private By paymentName = AppiumBy.androidUIAutomator("new UiSelector().text(\"Rebecca Winter\")");
    private By cardNumber = AppiumBy.accessibilityId("Card Number* input field");
    private By expireDate = AppiumBy.accessibilityId("Expiration Date* input field");
    private By securityCode = AppiumBy.accessibilityId("Security Code* input field");
    private By tickCheck = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    private By reviewOrder = AppiumBy.accessibilityId("Review Order button");

    public void fillPaymentFields(String name,String number,  String date, String code){
        inputElement(paymentName, name);
        inputElement(cardNumber, number);
        inputElement(expireDate, date);
        inputElement(securityCode, code);
        clickElement(reviewOrder);
    }
}
