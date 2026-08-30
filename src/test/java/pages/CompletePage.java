package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    private final SelenideElement successfulOrder = $(".complete-header");
    private final SelenideElement backHomeButton = $("#back-to-products");
    private final SelenideElement titleProducts = $(".title");

    public void successfulOrderAndBackHome() {
        successfulOrder.shouldHave(text("Thank you for your order!"));
        backHomeButton.click();
        titleProducts.shouldHave(text("Products"));
    }
}
