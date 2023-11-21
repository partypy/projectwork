package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import hu.masterfield.locators.OpeningPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningPage extends BasePage {
    @FindBy(xpath = OpeningPageLocators.COOKIE_ACCEPT_BUTTON)
    WebElement acceptCookieButton;

    public OpeningPage(WebDriver driver) {
        super(driver);
    }

    public TripPlanPage acceptCookies() {
        acceptCookieButton.click();
        return new TripPlanPage();
    }

    public boolean isPresented() {
        return super.isPresented(acceptCookieButton);
    }

}

