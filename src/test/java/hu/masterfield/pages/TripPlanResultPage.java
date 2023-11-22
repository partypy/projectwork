package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPlanResultPage extends BasePage {
    public TripPlanResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='noprint']")
    WebElement suggestedItinerariesHeader;

    public boolean isLoaded() {
        return isLoaded(suggestedItinerariesHeader);
    }
}
