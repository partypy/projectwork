package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class OpeningPage extends BasePage {
    @FindBy(xpath = "//button[@class='root-0-2-9 contained-0-2-10 button-0-2-2']")
    WebElement acceptCookieButton;

    public OpeningPage(WebDriver driver) {
        super(driver);
    }

    public TripPlanPage acceptCookies() {
        acceptCookieButton.click();
        checkCookies();
        return new TripPlanPage(driver);

    }

    public void checkCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        Assertions.assertFalse(cookies.isEmpty());
    }

    public boolean isLoaded() {
        return isLoaded(acceptCookieButton);
    }

}

