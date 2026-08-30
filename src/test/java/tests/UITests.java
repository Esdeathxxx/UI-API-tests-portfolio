package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class UITests {

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
    }
    @Test
    public void successfulE2EOrderTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage();
        productsPage.addProductsToCart();
        productsPage.goToCart();
        CartPage cartPage = new CartPage();
        cartPage.goCheckout();
        YourInformationPage yourInformationPage = new YourInformationPage();
        yourInformationPage.fillOutYourInfo("Anna", "Wong", "123321");
        yourInformationPage.clickContinue();
        OverviewPage overviewPage = new OverviewPage();
        overviewPage.selectedProducts();
        overviewPage.clickFinish();
        CompletePage completePage = new CompletePage();
        completePage.successfulOrderAndBackHome();
    }
    @Test
    public void negativeAuthorizationTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.verifyLockedOutErrorMessage();
    }
}
