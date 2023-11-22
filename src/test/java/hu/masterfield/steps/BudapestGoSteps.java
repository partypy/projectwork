package hu.masterfield.steps;

import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import hu.masterfield.pages.TripPlanPage;
import hu.masterfield.pages.TripPlanResultPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BudapestGoSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private OpeningPage openingPage;
    private TripPlanPage tripPlanPage;
    private TripPlanResultPage tripPlanResultPage;

    @BeforeAll
    public static void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

    @Given("I open BudapestGO")
    public void iOpenBudapestGO() {
        driver.get(Settings.BASE_URL);
        openingPage = new OpeningPage(driver);
        openingPage.isLoaded();
    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        tripPlanPage = openingPage.acceptCookies();

    }

    @Then("cookie window disappears")
    public void cookieWindowDisappears() {

        tripPlanPage.isLoaded();
    }

    @When("I set {string} into departure field")
    public void iSetIntoDepartureField(String departure) {
        tripPlanPage.setDepartureLocation(departure);

    }

    @And("I set {string} into destination field")
    public void iSetIntoDestinationField(String destination) {
        tripPlanPage.setDestinationLocation(destination);

    }

    @And("I plan the route")
    public void iPlanTheRoute() {
        tripPlanResultPage = tripPlanPage.startPlanning();

    }

    @Then("I get the possible routes")
    public void iGetThePossibleRoutes() {
        tripPlanResultPage.isLoaded();


    }
}
