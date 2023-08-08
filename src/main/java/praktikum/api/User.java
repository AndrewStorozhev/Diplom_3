package praktikum.api;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class User extends ConfigAPI {

    @Step("Метод Создание пользователя")
    @Description("POST USER_REGISTRATION")
    public Response registrationUser(UserRegistration userRegistration){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userRegistration)
                .when()
                .post(USER_REGISTRATION);
    }

    @Step("Метод Авторизация пользователя")
    @Description("POST USER_LOGIN")
    public Response loginUser(UserLogin userLogin){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userLogin)
                .when()
                .post(USER_LOGIN);
    }

    @Step("Метод Удаление пользователя")
    @Description("DELETE USER_BASE_URL")
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .delete(USER_BASE_URL);
    }

    @Step("Метод Выход из системы")
    @Description("POST USER_LOGOUT")
    public Response logoutUser(String accessToken){
        return given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .post(USER_LOGOUT);
    }

}
