package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class OpeningPage extends BasePage {
    @FindBy(xpath = "//button[text()='Elfogadom']")
    WebElement acceptCookieButton;

    public OpeningPage(WebDriver driver) {
        super(driver);
    }

    public TripPlanPage acceptCookies() {
        acceptCookieButton.click();
        return new TripPlanPage(driver);

    }

    public void getAllCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();

    }

    public boolean isLoaded() {
        return isLoaded(acceptCookieButton);
    }

}

