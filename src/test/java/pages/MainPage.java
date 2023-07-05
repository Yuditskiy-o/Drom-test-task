package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement brand = $x("//input[@placeholder='Марка']");
    private final SelenideElement brandToyota = $x("//*[contains(text(),'Toyota (')]");
    private final SelenideElement model = $x("//input[@placeholder='Модель']");
    private final SelenideElement modelHarrier = $x("//*[contains(text(),'Harrier (')]");
    private final SelenideElement fuelInput = $x("//button[text()='Топливо']");
    private final SelenideElement fuelHybrid = $x("//div[text()='Гибрид']");
    private final SelenideElement unsold = $x("//label[text()='Непроданные']");
    private final SelenideElement advSearch = $x("//span[text()='Расширенный поиск']");
    private final SelenideElement milesFrom = $x("//input[@placeholder='от, км']");
    private final SelenideElement yearFrom = $x("//*[text()='Год от']");
    private final SelenideElement year2007 = $x("//div[@class='css-u25ii9 e154wmfa0']//div[text()='2007']");
    private final SelenideElement show = $x("//div[text()='Показать']");
    private final SelenideElement login = $x("//a[@class='css-1h9spzo e1k6fwrt0']");
    private final ElementsCollection carFavoritesList = $$x("//*[@class='css-1rozdag']");
    private final SelenideElement favoritesButton = $x("(//a[@title='Избранное'])[2]");
    private final ElementsCollection brandsList = $$x("//*[@class='css-17vx1of e1x0dvi10']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    @Step("Кликнуть по полю 'Марка'")
    public MainPage clickFieldBrand() {
        brand.click();
        return this;
    }

    @Step("Заполнить поле 'Марка'")
    public MainPage fillFieldBrand(String text) {
        brand.click();
        brand.sendKeys(text);
        brandToyota.click();
        return this;
    }

    @Step("Заполнить поле 'Модель'")
    public MainPage fillFieldModel(String text) {
        model.click();
        model.sendKeys(text);
        modelHarrier.click();
        return this;
    }

    @Step("Заполнить поле 'Топливо'")
    public MainPage fillFieldFuel(String text) {
        fuelInput.click();
        fuelInput.sendKeys(text);
        fuelHybrid.click();
        return this;
    }

    @Step("Проставить чекбокс 'Непроданные'")
    public MainPage selectUnsold() {
        unsold.click();
        return this;
    }

    @Step("Заполнить поле 'Пробег' от")
    public MainPage fillFieldMilesFrom(String text) {
        milesFrom.setValue(text);
        return this;
    }

    @Step("Заполнить на поле 'Год' от")
    public MainPage fillFieldYearFrom() {
        yearFrom.click();
        year2007.click();
        return this;
    }

    @Step("Развернуть фильтр 'Расширенный поиск'")
    public void clickAdvSearch() {
        advSearch.click();
    }

    @Step("Нажать кнопку 'Показать'")
    public void clickButtonShow() {
        show.click();
    }

    @Step("Нажать кнопку 'Вход и регистрация'")
    public void clickButtonLogin() {
        login.click();
    }

    @Step("Заполнить необходимые значения фильтров")
    public MainPage fillCarFilters() {
        fillFieldBrand("Toyota");
        fillFieldModel("Harrier");
        fillFieldFuel("Гибрид");
        selectUnsold();
        fillFieldYearFrom();
        clickAdvSearch();
        fillFieldMilesFrom("1");
        clickButtonShow();
        return this;
    }

    @Step("Добавить объявление в избранное")
    public MainPage addToFavorites() throws InterruptedException {
        Thread.sleep(3000);
        carFavoritesList.first().click();
        return this;
    }

    @Step("Нажать на кнопку 'Избранное'")
    public MainPage clickButtonFavorites() {
        favoritesButton.click();
        return this;
    }

    @Step("Получить список всех автомобилей в выпадающем списке 'Марка'")
    public List<String> getAllAvailableCarAdvertisements() {
        List<String> carsListOne = new ArrayList<>();
        List<String> carsListTwo = new ArrayList<>();
        List<String> carsListThree = new ArrayList<>();
        List<String> carsListFour = new ArrayList<>();
        List<String> carsListFive = new ArrayList<>();
        List<String> carsListSix = new ArrayList<>();
        List<String> carsListSeven = new ArrayList<>();
        List<String> carsListEight = new ArrayList<>();
        List<String> carsListNine = new ArrayList<>();
        List<String> carsListTen = new ArrayList<>();
        List<String> carsListEleven = new ArrayList<>();
        List<String> carsListTwelve = new ArrayList<>();
        List<String> carsListThirteen = new ArrayList<>();
        List<String> carsListFourteen = new ArrayList<>();
        List<String> carsListFifteen = new ArrayList<>();
        List<String> carsListSixteen = new ArrayList<>();
        List<String> carsListSeventeen = new ArrayList<>();
        List<String> carsListEighteen = new ArrayList<>();


        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(0));
        for (SelenideElement selenideElement : brandsList) {
            carsListOne.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(3));
        for (SelenideElement selenideElement : brandsList) {
            carsListTwo.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(5));
        for (SelenideElement selenideElement : brandsList) {
            carsListThree.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListFour.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListFive.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListSix.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListSeven.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListEight.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListNine.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListTen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListEleven.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListTwelve.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListThirteen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListFourteen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListFifteen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(8));
        for (SelenideElement selenideElement : brandsList) {
            carsListSixteen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(4));
        for (SelenideElement selenideElement : brandsList) {
            carsListSeventeen.add(selenideElement.getText());
        }

        executeJavaScript("arguments[0].scrollIntoView(true);", brandsList.get(6));
        for (SelenideElement selenideElement : brandsList) {
            carsListEighteen.add(selenideElement.getText());
        }

        List<String> carsListUndone = Stream.of(carsListOne, carsListTwo, carsListThree, carsListFour, carsListFive,
                        carsListSix, carsListSeven, carsListEight, carsListNine, carsListTen, carsListEleven, carsListTwelve,
                        carsListThirteen, carsListFourteen, carsListFifteen, carsListSixteen, carsListSeventeen, carsListEighteen)
                .flatMap(Collection::stream).collect(Collectors.toList());
        Set<String> set = new LinkedHashSet<>(carsListUndone);
        carsListUndone.clear();
        carsListUndone.addAll(set);

        List<String> carsListFinal = new ArrayList<>(set);
        carsListFinal.removeAll(Collections.singleton(""));
        return carsListFinal;
    }

    @Step("Вывести список {0} из {1} позиций в порядке убывания")
    public void sortCarsAndShowSpecificAmountInReversedOrder(List<String> list, int limit) {
        Map<String, Integer> brandCounts = new HashMap<>();

        for (String option : list) {
            String brandName = option.replaceAll("[^A-Za-z]+", "");
            int count = Integer.parseInt(option.replaceAll("\\D+", ""));

            brandCounts.put(brandName, count);
        }

        // Сортируем фирмы по количеству объявлений в убывающем порядке,
        // оставляя необходимое количество позиций
        List<Map.Entry<String, Integer>> sortedBrands = brandCounts
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .collect(Collectors.toList());

        // Выводим список из 20 фирм с наибольшим количеством объявлений
        for (Map.Entry<String, Integer> entry : sortedBrands) {
            String brand = entry.getKey();
            int count = entry.getValue();
            System.out.println("|--------------|-----------------------|");
            System.out.println("|    Фирма     | Количество объявлений |");
            System.out.println("|--------------|-----------------------|");
            System.out.printf("| %-10s   | %-20s   |%n", brand, count);
        }
    }

}
