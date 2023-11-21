package hu.masterfield.baseitems;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {

    public static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
