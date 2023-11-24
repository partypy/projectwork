package hu.masterfield.layout;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.browser.Settings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BudapestGOLayoutTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeAll
    public static void driverInit() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void budapestGOTripPlan() throws IOException, InterruptedException {
        driver.get(Settings.BASE_URL);
        WebElement cookieAcceptButtonApprears = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Elfogadom']")));
        //WebElement acceptCookieButton = driver.findElement(By.xpath("//button[text()='Elfogadom']"));
        cookieAcceptButtonApprears.click();
        WebElement departureInputField = driver.findElement(By.xpath("//input[@class='planner-from ui-widget-content ui-corner-all ui-autocomplete-input']"));
        departureInputField.sendKeys("Savoya Park" + Keys.TAB);
        WebElement destinationToInputField = driver.findElement(By.xpath("//input[@class='planner-to ui-widget-content ui-corner-all ui-autocomplete-input']"));
        destinationToInputField.sendKeys("Újpest-városkapu" + Keys.TAB);
        WebElement planButton = driver.findElement(By.xpath("//input[@class='planner-button planner-plan ui-button ui-widget ui-state-default ui-corner-all']"));
        wait.until(ExpectedConditions.elementToBeClickable(planButton));
        planButton.click();

        List<String> tags = new ArrayList<>();
        LayoutReport report = Galen.checkLayout(driver, "/specs/budapestGO.gspec", tags);
        createReport(report);
    }

    public void createReport(LayoutReport report) throws IOException {
        GalenTestInfo testInfo = GalenTestInfo.fromString("BudapestGO trip planing page");
        testInfo.getReport().layout(report, "BudapestGO trip planing page layout test");
        List<GalenTestInfo> testInfoList = new ArrayList<GalenTestInfo>();

        testInfoList.add(testInfo);
        new HtmlReportBuilder().build(testInfoList, "galen/test-report/");
    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

}
