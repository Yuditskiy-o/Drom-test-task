package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FavoritesPage {
    private final SelenideElement emptyBookmarksText = $x("//div[contains(@class,'emptyPersonal emptyBookmark')]");
    private final SelenideElement removeBookmark = $x("//a[@class='removeBookmark']");
    private final SelenideElement alertForRemovedBookmark = $x("//*[@class='sys-message info']");


    @Step("Проверка отсутствия текста 'Вы ничего не добавили в избранное'")
    public boolean isEmptyBookmarksTextDisplayed() {
        return emptyBookmarksText.isDisplayed();
    }

    @Step("Удалить автомобиль из избранного")
    public FavoritesPage removeBookmark() {
        removeBookmark.click();
        return this;
    }

    @Step("Проверка появления всплывающего сообщения об удалении авто из избранного")
    public String isAlertForRemovedBookmarkDisplayed() {
        return alertForRemovedBookmark.getText();
    }
}
