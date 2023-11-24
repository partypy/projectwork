package hu.masterfield.layout;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.browser.Settings;
import hu.masterfield.pages.OpeningPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BudapestGOLayoutTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @FindBy(xpath = "//button[text()='Elfogadom']")
    WebElement acceptCookieButton;

    @FindBy(xpath = "//input[@class='planner-from ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement departureInputField;

    @FindBy(xpath = "//input[@class='planner-to ui-widget-content ui-corner-all ui-autocomplete-input']")
    WebElement destinationToInputField;

    @FindBy(xpath = "//input[@class='planner-button planner-plan ui-button ui-widget ui-state-default ui-corner-all']")
    WebElement planButton;

    @BeforeAll
    public static void driverInit() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public void budapestGOTripPlan() throws IOException {
        driver.navigate().to(Settings.BASE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
        acceptCookieButton.click();
        departureInputField.sendKeys("Savoya Park" + Keys.TAB);
        destinationToInputField.sendKeys("Újpest-városkapu" + Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(planButton));
        planButton.click();

        List<String> tags = new ArrayList<>();
        LayoutReport report = Galen.checkLayout(driver, "/specs/budapestGO.gspec", tags);
    }

    public void createReport(LayoutReport report) throws IOException {
        GalenTestInfo testInfo = GalenTestInfo.fromString("BudapestGO trip planing page");
        testInfo.getReport().layout(report, "BudapestGO trip planing page layout test");
        List<GalenTestInfo> testInfoList = new ArrayList<GalenTestInfo>();

        testInfoList.add(testInfo);
        new HtmlReportBuilder().build(testInfoList, "galen/test-report/");
    }

}
