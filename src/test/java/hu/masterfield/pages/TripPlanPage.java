package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPlanPage extends BasePage {

    @FindBy(xpath = "//input[@class='planner-from ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement departureInputField;

    @FindBy(xpath = "//input[@class='planner-to ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement destinationToInputField;


    @FindBy(xpath = "//input[@class='planner-button planner-plan ui-button ui-widget ui-state-default ui-corner-all']")
    WebElement planButton;

    public TripPlanPage(WebDriver driver) {
        super(driver);
    }

    public void setDepartureLocation(String departure) {
        departureInputField.sendKeys(departure + Keys.TAB);
    }

    public void setDestinationLocation(String destination) {
        destinationToInputField.sendKeys(destination + Keys.TAB);
    }

    public TripPlanResultPage startPlanning() {
        planButton.click();
        return new TripPlanResultPage(driver);
    }

    public boolean isLoaded() {
        return isLoaded(departureInputField)
                && isLoaded(departureInputField)
                && isLoaded(destinationToInputField)
                && isLoaded(planButton);
    }
}
