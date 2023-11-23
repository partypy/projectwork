package hu.masterfield.pages;

import hu.masterfield.baseitems.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TripPlanPage extends BasePage {

    @FindBy(xpath = "//input[@class='planner-from ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement departureInputField;

    @FindBy(xpath = "//input[@class='planner-to ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement destinationToInputField;

    @FindBy(xpath = "//input[@class='planner-button planner-plan ui-button ui-widget ui-state-default ui-corner-all']")
    WebElement planButton;

    @FindBy(id = "ui-accordion-1-header-0")
    WebElement planningOptionsButton;

    @FindAll({
            @FindBy(xpath = "//label[@for='mod-SUBWAY']"),
            @FindBy(xpath = "//label[@for='mod-SUBURBAN_RAILWAY']"),
            @FindBy(xpath = "//label[@for='mod-FERRY']"),
            @FindBy(xpath = "//label[@for='mod-TROLLEYBUS']"),
            @FindBy(xpath = "//label[@for='mod-BUS']"),
            @FindBy(xpath = "//label[@for='mod-RAIL']"),
            @FindBy(xpath = "//label[@for='mod-COACH']")
    })
    List<WebElement> undesiredVehicleButtons;

    @FindBy(id = "mod-TRAM")
    WebElement tramCheckbox;

    @FindBy(xpath = "//div[@class='trip-plan-view']")
    WebElement tripPlanRoute;

    @FindBy(xpath = "//canvas[@aria-label='Map']")
    WebElement map;

    @FindBy(xpath = "//span[@style='background-color: rgb(255, 216, 0); color: rgb(0, 0, 0);']")
    WebElement tramColor;


    public TripPlanPage(WebDriver driver) {
        super(driver);
    }

    public TripPlanResultPage fromToTripPlan(String departure, String destination) {
        departureInputField.sendKeys(departure + Keys.TAB);
        destinationToInputField.sendKeys(destination + Keys.TAB);
        planButton.click();
        return new TripPlanResultPage(driver);
    }


    public TripPlanResultPage filterVehicleTypes(String departure, String destination) throws InterruptedException {
        departureInputField.sendKeys(departure + Keys.TAB);
        destinationToInputField.sendKeys(destination + Keys.TAB);
        planningOptionsButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(undesiredVehicleButtons));
        deselect();
        wait.until(ExpectedConditions.elementToBeClickable(planButton));
        planButton.click();
        isLoaded(tripPlanRoute);
        isLoaded(map);
        return new TripPlanResultPage(driver);
    }

    public void deselect() {
        for (WebElement element : undesiredVehicleButtons) {
            element.click();
        }
    }

    public boolean isLoaded() {
        return isLoaded(departureInputField) && isLoaded(destinationToInputField) && isLoaded(planButton);
    }


}
