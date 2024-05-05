package tests;

import api.RestAssuredSteps;
import helpers.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static configs.Props.props;
import static testdata.UsersList.USER1;

public class RegistrationAndAuthorizationTests extends WebHooks {

    @Test
    @Order(1)
    @Tag("Полная процедура регистрации пользователя")
    @DisplayName("ТК 01 Проверка создание, авторизации и удаления пользователя")
    public void NewUserRegistration() {
        RestAssuredSteps restAssuredSteps = new RestAssuredSteps();
        restAssuredSteps.cleanDb();
        new WebHooks()
                .open(props.URL());
        new LoginPage()
                .userRegistration(USER1)
                .userLogOut()
                .login(USER1)
                .userLogOut()
                .recoveryData(USER1)
                .userLogOut();
        restAssuredSteps.cleanDb();
    }
}
