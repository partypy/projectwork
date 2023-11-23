package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class OpeningPage extends BasePage {
    @FindBy(xpath = "//button[text()='Elfogadom']")
    WebElement acceptCookieButton;

    @FindBy(tagName = "//h2")
    WebElement planText;

    public OpeningPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        //wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
        acceptCookieButton.click();
        checkCookies();

    }

    public TripPlanPage checkCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        Assertions.assertFalse(cookies.isEmpty());
        return new TripPlanPage(driver);
    }

    public boolean isLoaded() {
        return isLoaded(acceptCookieButton);
    }

}

