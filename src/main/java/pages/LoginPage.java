package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import testdata.UsersList;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static commonelements.AHref.aWithText;
import static commonelements.Input.inputName;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPage extends MainPage {

    //region Selenide элементы для объекта страницы
    private final SelenideElement loginField = $x("//input[@name='username']").as("Поле ввода логина");
    private final SelenideElement passField = $x("//input[@name='password']").as("Поле ввода пароля");
    private final SelenideElement loginBtn = $x("//input[@type='submit']").as("Кнопка авторизации");
    private final SelenideElement registrationAndRecoveryBtn = $x("(//input[@type='submit'])[2]")
            .as("Кнопка регистрации");
    private final SelenideElement successText = $x("//h1/following-sibling::p")
            .as("Текст с результатом регистрации");

    private final SelenideElement userLoginInfo = $x("(//h1/following-sibling::p)[2]")
            .as("Текст с результатом регистрации");
    private final SelenideElement welcomeMessage = $x("//p[@class='smallText']")
            .as("Приветственное сообщение с Именем и Фамилией пользователя");
    //endregion

    public static final String ERROR_MESSAGE = "Текст с результатом регистрации не совпадает";

    @Step("Авторизация под логином")
    public LoginPage login(UsersList user) {
        loginField.sendKeys(user.getUsername());
        passField.sendKeys(user.getPassword());
        loginBtn.click();
        welcomeMessage.shouldBe(visible, Duration.ofSeconds(10));
        assertEquals(welcomeMessage.getText(),
                "Welcome " + user.getFirstName() + " " + user.getLastName(),
                "Авторизация под пользователем не успешна");
        return this;
    }

    @Step("Регистрация нового пользователя")
    public LoginPage userRegistration(UsersList user) {
        aWithText("Register").click();
        inputName("customer.firstName", "Имя").sendKeys(user.getFirstName());
        inputName("customer.lastName", "Фамилия").sendKeys(user.getLastName());
        inputName("customer.address.street", "Адрес").sendKeys(user.getAddress());
        inputName("customer.address.city", "Город").sendKeys(user.getCity());
        inputName("customer.address.state", "Регион").sendKeys(user.getState());
        inputName("customer.address.zipCode", "Почтовый индекс").sendKeys(user.getZipCode());
        inputName("customer.phoneNumber", "Телефон").sendKeys(user.getPhone());
        inputName("customer.ssn", "ИНН").sendKeys(user.getSsn());
        inputName("customer.username", "Логин").sendKeys(user.getUsername());
        inputName("customer.password", "Пароль").sendKeys(user.getPassword());
        inputName("repeatedPassword", "Подтверждение пароля").sendKeys(user.getPassword());
        registrationAndRecoveryBtn.click();
        assertEquals(successText.getText(),
                "Your account was created successfully. You are now logged in.", ERROR_MESSAGE);
        return this;
    }

    @Step("Восстановление данных пользоватлея")
    public LoginPage recoveryData(UsersList user) {
        aWithText("Forgot login info?").click();
        inputName("firstName", "Имя").sendKeys(user.getFirstName());
        inputName("lastName", "Фамилия").sendKeys(user.getLastName());
        inputName("address.street", "Адрес").sendKeys(user.getAddress());
        inputName("address.city", "Город").sendKeys(user.getCity());
        inputName("address.state", "Регион").sendKeys(user.getState());
        inputName("address.zipCode", "Почтовый индекс").sendKeys(user.getZipCode());
        inputName("ssn", "ИНН").sendKeys(user.getSsn());
        registrationAndRecoveryBtn.click();
        Assertions.assertAll(
                () -> assertEquals("Your login information was located successfully. You are now logged in.",
                        successText.getText(), ERROR_MESSAGE),
                () -> assertEquals("Username: " + user.getUsername() + "\n" + "Password: " + user.getPassword(),
                        userLoginInfo.getText(), ERROR_MESSAGE)
        );
        return this;
    }

    @Step("Выход из профиля")
    public LoginPage userLogOut() {
        aWithText("Log Out").click();
        return this;
    }
}