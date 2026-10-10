package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckOutPage extends BasePage {
    private By checkOutName = AppiumBy.accessibilityId("Full Name* input field");
    private By addressLine1 = AppiumBy.accessibilityId("Address Line 1* input field");
    private By addressLine2 = AppiumBy.accessibilityId("Address Line 2 input field");
    private By cityInput = AppiumBy.accessibilityId("City* input field");
    private By stateInput = AppiumBy.accessibilityId("State/Region input field");
    private By zipcodeInput = AppiumBy.accessibilityId("Zip Code* input field");
    private By countryInput = AppiumBy.accessibilityId("Country* input field");
    private By toPaymentBtn = AppiumBy.accessibilityId("To Payment button");
    private By paymentName = AppiumBy.accessibilityId("Full Name* input field");
    private By cardNumber = AppiumBy.accessibilityId("Card Number* input field");
    private By expireDate = AppiumBy.accessibilityId("Expiration Date* input field");
    private By securityCode = AppiumBy.accessibilityId("Security Code* input field");
    private By tickCheck = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    private By reviewOrder = AppiumBy.accessibilityId("Review Order button");
  public void fillInFields(String name, String address1, String address2, String city, String state, String zipcode, String country){
      inputElement(checkOutName, name);
      inputElement(addressLine1, address1);
      inputElement(addressLine2, address2);
      inputElement(cityInput, city);
      inputElement(stateInput, state);
      inputElement(zipcodeInput, zipcode);
      inputElement(countryInput, country);
      clickElement(toPaymentBtn);
  }


}
