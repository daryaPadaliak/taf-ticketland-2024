package by.itacademy.padaliak.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    @DisplayName("Login as not registered user")
    public void testLogin1() {
        given().
                body(Login.getBody("test@gmail.com", "Password1@")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Не удалось авторизовать пользователя по указанным контактам"));
    }

    @Test
    @DisplayName("Login with empty Email field")
    public void testLogin2() {
        given().
                body(Login.getBody("", "Password1@")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Введите логин")).
                body("fields.contact[1]", equalTo("Укажите телефон или e-mail"));
    }

    @Test
    @DisplayName("Login with empty Password field")
    public void testLogin3() {
        given().
                body(Login.getBody("test456@gmail.com", "")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.password[0]", equalTo("Введите пароль"));
    }

    @Test
    @DisplayName("Login with empty email and empty password fields")
    public void testLogin4() {
        given().
                body(Login.getBody("", "")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.password[0]", equalTo("Введите пароль")).
                body("fields.contact[0]", equalTo("Введите логин")).
                body("fields.contact[1]", equalTo("Укажите телефон или e-mail"));
    }

    @Test
    @DisplayName("Login with empty body")
    public void testLogin5() {

        String body = "{}";
        given().
                body(body).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.password[0]", equalTo("Введите пароль")).
                body("fields.contact[0]", equalTo("Введите логин")).
                body("fields.contact[1]", equalTo("Укажите телефон или e-mail"));
    }

    @Test
    @DisplayName("Login with null values")
    public void testLogin6() {
        given().
                body(Login.getBody("null", "null")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Некорректный формат логина"));
    }

    @Test
    @DisplayName("Login with invalid email format")
    public void testLogin7() {
        given().
                body(Login.getBody("$5%^^", "Password1@")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Некорректный формат логина"));
    }

    @Test
    @DisplayName("Login with invalid password format")
    public void testLogin8() {
        given().
                body(Login.getBody("test34@gmail.com", "@")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Не удалось авторизовать пользователя по указанным контактам"));
    }

    @Test
    @DisplayName("Login with long email field")
    public void testLogin9() {
        given().
                body(Login.getBody("tesruytreytuireytuierytuiryetuiyeruityeiyteiuwytuiewyruifhjdsbfsnvmbxmncbvmncxbvmncxbvmnxbmnbxzmcbzxnmbcnmzxbcnmxzbcnmxzbcnmxzbcnmxzbcmnzxbcnmzxbcnxzsfghdgsfhdjsgfjhsdgfhjsdgfhjgsdhjfghjdsgfhjdgsfhjgdshjfghjdsgfhgdshjgfhjdsgfhjdsghjfghjdsgfhjdsgfhjgdsjgfhjsdghjgfhdsgft34@gmail.com", "@")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Некорректный формат логина"));
    }

    @Test
    @DisplayName("Login using tags")
    public void testLogin10() {
        given().
                body(Login.getBody("<b> Bold Tag </b>", "<b> Bold Tag </b>")).
                headers(Login.getHeaders()).
                when().
                post(Login.URL).
                then().log().all().
                statusCode(400).
                body("message", equalTo("Ошибка заполнения формы")).
                body("fields.contact[0]", equalTo("Некорректный формат логина"));
    }
}
