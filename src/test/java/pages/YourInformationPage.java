package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {
    private final SelenideElement yourinfoLogo = $(".title");
    private final SelenideElement firstNameField = $("#first-name");
    private final SelenideElement lastNameField = $("#last-name");
    private final SelenideElement zipField = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");

    public void fillOutYourInfo(String firstname, String lastname, String zip) {
        yourinfoLogo.shouldHave(text("Checkout: Your Information"));
        firstNameField.setValue(firstname);
        lastNameField.setValue(lastname);
        zipField.setValue(zip);
    }
    public void clickContinue() {
        continueButton.click();
    }
}
