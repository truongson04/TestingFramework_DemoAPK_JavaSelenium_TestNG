package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage{
    private By increaseBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");
    private By grayColor = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(31)");
    private By addBtn = AppiumBy.accessibilityId("Add To Cart button");
    private By cartIcon = AppiumBy.androidUIAutomator("new UiSelector().text(\"3\").instance(0)");
    private By totalNumber = AppiumBy.accessibilityId("total number");// text is 3

public  void increaaseItems(){
    clickWhenVisible(increaseBtn);

}
public void selectGrayColor(){
    clickWhenVisible(grayColor);
}
public void clickAddToCart(){
    clickElement(addBtn);
}
public void clickCartIcon(){
    clickWhenVisible(cartIcon);
}

    public By getCartIcon() {
        return cartIcon;
    }
    public By getTotalNumber(){
    return totalNumber;
    }
}
