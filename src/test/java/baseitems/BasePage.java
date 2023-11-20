package baseitems;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BasePage {
    @BeforeAll
    public static void initialize(){
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = Settings.BASE_URL;
        Configuration.browserSize = "1920x1080";

    }
}
