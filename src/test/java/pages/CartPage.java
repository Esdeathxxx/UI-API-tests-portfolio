package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    private final SelenideElement yourCartLogo = $(".title");
    private final SelenideElement checkoutButton = $("#checkout");

    public void goCheckout() {
    yourCartLogo.shouldHave(text("Your Cart"));
    checkoutButton.click();
    }
}
