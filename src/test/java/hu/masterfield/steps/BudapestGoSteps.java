package hu.masterfield.steps;

import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BudapestGoSteps {
    WebDriver driver;
    OpeningPage openingPage;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        openingPage = new OpeningPage(this.driver);
        driver.manage().window().maximize();
    }

    @Given("I open BudapestGO")
    public void iOpenBudapestGO() {
        driver.get(Settings.BASE_URL);
    }

    @And("the cookie accept button is presented")
    public void theCookieAcceptButtonIsPresented() {
        Assertions.assertTrue(openingPage.isPresented());
    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        openingPage.acceptCookies();
    }

    @Then("cookie window disappears")
    public void cookieWindowDisappears() {
        Assertions.assertFalse(openingPage.isPresented());
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
