package hu.masterfield.steps;

import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AcceptCookiesSteps {
    WebDriver driver;
    OpeningPage openingPage = new OpeningPage(driver);

    @Given("I open BudapestGO")
    public void iOpenBudapestGO() {
        driver.get(Settings.BASE_URL);
    }

    @And("the cookie accept button is presented")
    public void theCookieAcceptButtonIsPresented() {

    }

    @When("I accept cookies")
    public void iAcceptCookies() {
    }

    @Then("cookie window disappears")
    public void cookieWindowDisappears() {
    }
}
