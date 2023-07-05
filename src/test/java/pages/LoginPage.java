package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement username = $x("//*[@id='sign']");
    private final SelenideElement pass = $x("//*[@id='password']");

    @Step("Авторизоваться на сайте используя логин {0} и пароль {1}")
    public LoginPage auth(String login, String password) {
        username.setValue(login);
        pass.setValue(password);
        pass.submit();
        return this;
    }



}
