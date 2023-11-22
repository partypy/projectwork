package hu.masterfield.steps;

import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import hu.masterfield.pages.TripPlanPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BudapestGoSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private OpeningPage openingPage;
    private TripPlanPage tripPlanPage;

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


}
