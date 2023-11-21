package hu.masterfield.pages;

import hu.masterfield.locators.OpeningPageLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class OpeningPage {

    SelenideElement acceptButton = Selenide.$x(OpeningPageLocators.COOKIE_ACCEPT_BUTTON);

    public void clickOnAcceptButton() {
        acceptButton.click();
    }

    public void isLoaded() {
        acceptButton.shouldBe(Condition.visible).shouldBe(Condition.enabled);
    }

}

