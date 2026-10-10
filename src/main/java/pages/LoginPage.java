package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By nameInput = AppiumBy.accessibilityId("Username input field");
    private By passwordInput = AppiumBy.accessibilityId("Password input field");
    private By loginBtn = AppiumBy.accessibilityId("Login button");
    public void login(String name, String password){
        inputElement(nameInput, name);
        inputElement(passwordInput, password);
        clickElement(loginBtn);
    }
}
