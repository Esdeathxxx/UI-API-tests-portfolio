package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {
    private final SelenideElement titleProducts = $(".title");
    private final SelenideElement addBackpackToCart = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement addTshirtToCart = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");
    private final SelenideElement cartButton = $(".shopping_cart_link");

    public void addProductsToCart() {
        titleProducts.shouldHave(text("Products"));
        addBackpackToCart.click();
        addTshirtToCart.click();
        cartBadge.shouldHave(text("2"));
    }
    public void goToCart() {
        cartButton.click();
    }
}
