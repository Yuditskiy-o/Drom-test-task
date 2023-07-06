package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import helpers.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.Constants.*;
import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestListener.class)
@DisplayName("Задание 2 тестового задания Drom.ru")
public class DromTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Различные проверки листинга автомобилей по заданным фильтрам")
    void shouldCheckCarListing() {
        step("1. На странице сайта https://www.drom.ru/catalog/ заполнить необходимые данные в фильтрах поиска", () -> {
            mainPage.fillCarFilters();
        });

        step("2. После применения фильтров проверить автомобили в выдаче на соответствие определенным проверкам", () -> {
            carListingFirstPage
                    .checkCarTitles("2006")
                    .checkCarStates()
                    .checkCarCharacteristics("км");
        });

        step("3. Перейти на 2-ю страницу выдачи автомобилей", () -> {
            carListingFirstPage.goToSecondPage();
        });

        step("4. Проверить автомобили на 2-й странице в выдаче на соответствие определенным проверкам", () -> {
            carListingSecondPage
                    .checkCarTitles("2006")
                    .checkCarStates()
                    .checkCarCharacteristics("км");
        });
    }

    @Test
    @Order(2)
    @DisplayName("Авторизация на сайте, добавление объявления в 'Избранное' и последующее удаление")
    void shouldLoginAndAddToFavorites() {
        step("1. На странице сайта https://www.drom.ru/catalog/ нажать кнопку 'Вход и регистрация'", () ->
                mainPage.clickButtonLogin());

        step("2. Заполнить поля 'Логин' и 'Пароль', нажать кнопку 'Войти с паролем'", () -> {
            loginPage.auth(LOGIN, PASSWORD);
        });

        step("3. Добавить 1-е объявление из листинга в избранное, затем нажать кнопку 'Избранное'", () -> {
            mainPage.addToFavorites()
                    .clickButtonFavorites();
        });

        step("Проверка отсутствия текста 'Вы ничего не добавили в избранное'", () ->
                Assertions.assertFalse(favoritesPage.isEmptyBookmarksTextDisplayed()));

        step("4. Удалить объявление из избранного", () -> {
            favoritesPage.removeBookmark();
        });

        step("Проверка появления всплывающего сообщения об удалении авто из избранного", () ->
                Assertions.assertTrue(favoritesPage.isAlertForRemovedBookmarkDisplayed().contains("Удалено из избранного")));
    }

    @Test
    @Order(3)
    @DisplayName("Проверка корректной сортировки автомобилей из выпадающего списка 'Марка'")
    void shouldShowCarListWithOrder() {
        step("1. Открыть сайт https://auto.drom.ru/region25/ и развернуть браузер на весь экран", () -> {
            Selenide.open(URL_25_REGION);
            WebDriverRunner.getWebDriver().manage().window().maximize();
        });

        step("2. Кликнуть по фильтру 'Марка', затем получить все марки авто с активными объявлениями, отфильтровать " +
                "в порядке убывания количества объявлений и вывести на экран первые 20 позиций", () ->
                mainPage.clickFieldBrand()
                        .sortCarsAndShowSpecificAmountInReversedOrder(mainPage.getAllAvailableCarAdvertisements(), 20));
    }
}
