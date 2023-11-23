package hu.masterfield.steps;

import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import hu.masterfield.pages.TripPlanPage;
import hu.masterfield.pages.TripPlanResultPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
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

    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        openingPage.acceptCookies();
        tripPlanPage = openingPage.checkCookies();

    }

    @Then("cookie window disappears")
    public void cookieWindowDisappears() {
        tripPlanPage.isLoaded();
    }

    @When("I plan a trip from  {string} to {string}")
    public void iPlanATripFromTo(String departure, String destination) {
        tripPlanResultPage = tripPlanPage.fromToTripPlan(departure, destination);

    }

    @Then("I get the possible routes")
    public void iGetThePossibleRoutes() {
        tripPlanResultPage.isLoaded();
    }

    @When("I plan route from {string} to {string} only with tram")
    public void iPlanRouteFromToOnlyWithTram(String departure, String destination) throws InterruptedException {
        tripPlanResultPage = tripPlanPage.filterVehicleTypes(departure, destination);
        Thread.sleep(5000);
    }

    @Then("I get only tram routes")
    public void iGetOnlyTramRoutes() {

    }

}
