package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginLogo = $(".login_logo");
    private final SelenideElement errorMessage = $("h3");
    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login-button");

    public void login(String username, String password) {
        loginLogo.shouldHave(text("Swag Labs"));
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }
    public void verifyLockedOutErrorMessage() {
        errorMessage.shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }
}
