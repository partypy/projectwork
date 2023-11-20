package pages;

import baseitems.Locators;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CookiePage {

    SelenideElement acceptButton = Selenide.$x(Locators.COOKIEACCEPTBUTTON);
    SelenideElement detailsButton = Selenide.$x(Locators.COOKIEDETAILSBUTTON);
    SelenideElement declineCookieButton = Selenide.$x(Locators.COOKIEDECLINEBUTTON);


}
