package tests;

import api.RestAssuredSteps;
import helpers.WebHooks;
import org.junit.jupiter.api.*;
import pages.LoginPage;

import static configs.Props.props;
import static testdata.UsersList.USER1;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests extends WebHooks {

    @Test
    @Order(1)
    @Tag("Регистрация пользователя")
    @DisplayName("ТК 01.1 Регистрация нового пользователя")
    public void NewUserRegistration() {
        new WebHooks()
                .open(props.URL());
        new LoginPage()
                .userRegistration(USER1);
        System.out.println();
    }

    @Test
    @Order(2)
    @Tag("Регистрация пользователя")
    @DisplayName("ТК 01.2 Авторизация в банке")
    public void UserAuthorization() {
        new WebHooks()
                .open(props.URL());
        new LoginPage()
                .login(USER1);
    }

    @Test
    @Order(3)
    @Tag("Регистрация пользователя")
    @DisplayName("ТК 01.3 Восстановление данных пользователя")
    public void UserDataRecovery() {
        new WebHooks()
                .open(props.URL());
        new LoginPage()
                .recoveryData(USER1);
    }

    @Test
    @Order(4)
    @Tag("Регистрация пользователя")
    @DisplayName("ТК 01.4 Удаление базы данных с пользователями")
    public void DeleteUserData() {
        new RestAssuredSteps().cleanDb();
    }
}
