package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Constants.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DromTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Различные проверки листинга автомобилей по заданным фильтрам")
    void shouldCheckCarListing() {
        mainPage.fillCarFilters();

        carListingFirstPage
                .checkCarTitles("2006")
                .checkCarStates()
                .checkCarCharacteristics("км");

        carListingFirstPage.goToSecondPage();

        carListingSecondPage
                .checkCarTitles("2006")
                .checkCarStates()
                .checkCarCharacteristics("км");
    }

    @Test
    @Order(2)
    @DisplayName("Авторизация на сайте, добавление объявления в 'Избранное' и последующее удаление")
    void shouldLoginAndAddToFavorites() {
        mainPage.clickButtonLogin();
        loginPage.auth(LOGIN, PASSWORD);

        mainPage.addToFavorites()
                .clickButtonFavorites();

        Assertions.assertFalse(favoritesPage.isEmptyBookmarksTextDisplayed());
        favoritesPage.removeBookmark();
        Assertions.assertTrue(favoritesPage.isAlertForRemovedBookmarkDisplayed().contains("Удалено из избранного"));
    }

    @Test
    @Order(3)
    @DisplayName("Проверка корректной сортировки автомобилей из выпадающего списка 'Маока'")
    void shouldShowCarListWithOrder() {
        Selenide.open(URL_25_REGION);

        mainPage.clickFieldBrand()
                .sortCarsAndShowSpecificAmountInReversedOrder(mainPage.getAllAvailableCarAdvertisements(), 20);
    }
}
