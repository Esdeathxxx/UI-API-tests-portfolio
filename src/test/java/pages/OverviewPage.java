package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private final SelenideElement overviewLogo = $(".title");
    private final SelenideElement backpack = $("#item_4_title_link");
    private final SelenideElement tshirt = $("#item_1_title_link");
    private final SelenideElement totalPrice = $(".summary_total_label");
    private final SelenideElement finishButton = $("#finish");

    public void selectedProducts() {
        overviewLogo.shouldHave(text("Checkout: Overview"));
        backpack.shouldHave(text("Sauce Labs Backpack"));
        tshirt.shouldHave(text("Sauce Labs Bolt T-Shirt"));
        totalPrice.shouldHave(text("Total: $49.66"));
    }
    public void clickFinish() {
        finishButton.click();
    }
}
