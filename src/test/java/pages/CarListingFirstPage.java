package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CarListingFirstPage {

    private final ElementsCollection carTitlesList = $$x("//*[@class='css-l1wt7n e3f4v4l2']//span");
    private final ElementsCollection carStateList = $$x("//*[@class='css-11m58oj evjskuu0']//div");
    private final ElementsCollection carCharacteristicsList = $$x("//*[@class='css-1fe6w6s e162wx9x0']");
    private final SelenideElement secondPage = $x("//a[@class='css-4gbnjj e24vrp30']");

    public CarListingFirstPage checkCarTitles(String value) {
        for (SelenideElement e : carTitlesList) {
            if (e.getText().contains(value)) {
                    Assertions.fail("В списке есть автомобиль ниже 2007 года выпуска!");
            }
        }
        return this;
    }

    public CarListingFirstPage checkCarStates() {
        for (SelenideElement e : carStateList) {
            if (!e.getText().contains("хорошая цена") && e.getText().contains("нормальная цена") &&
                    e.getText().contains("высокая цена") && e.getText().contains("без оценки")) {
                    Assertions.fail("В списке есть автомобиль снятый с продажи!");
            }
        }

        return this;
    }

    public CarListingFirstPage checkCarCharacteristics(String value) {
        for (SelenideElement e : carCharacteristicsList) {
            if (!e.getText().contains(value)) {
                Assertions.fail("В списке есть автомобиль без пробега!");
            }
        }
        return this;
    }

    @Step("Перейти на 2-ю страницу пагинации")
    public CarListingSecondPage goToSecondPage(){
        secondPage.click();
        return new CarListingSecondPage();
    }
}
