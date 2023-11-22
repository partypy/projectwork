package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPlanPage extends BasePage {

    @FindBy(xpath = "//input[@class='planner-from ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement searchFromInputField;

    public TripPlanPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isLoaded(searchFromInputField);
    }
}
