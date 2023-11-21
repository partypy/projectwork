package hu.masterfield.browser;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Browser {
    @BeforeAll
    public static void initialize(){
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = Settings.BASE_URL;
        Configuration.browserSize = "1920x1080";

    }
}
