package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.*;

import static helpers.Constants.URL;

abstract public class BaseTest {

    protected MainPage mainPage = new MainPage(URL);
    protected CarListingFirstPage carListingFirstPage = new CarListingFirstPage();
    protected CarListingSecondPage carListingSecondPage = new CarListingSecondPage();
    protected LoginPage loginPage = new LoginPage();
    protected FavoritesPage favoritesPage = new FavoritesPage();

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1440x900";
        Configuration.headless = false;
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}