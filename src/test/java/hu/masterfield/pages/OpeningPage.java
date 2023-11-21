package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningPage extends BasePage {
    @FindBy(xpath = "//button[text()='Elfogadom']")
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

