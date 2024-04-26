package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.page.PageObject;
import by.itacademy.padaliak.ui.user.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    PageObject pageObject = new PageObject();

    @Test
    @DisplayName("Login with not registered user")
    public void testLogin1() {
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail(Users.getUserByEmail().getEmail());
        pageObject.inputPassword(Users.getUserByEmail().getPassword());
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Не удалось авторизовать пользователя по указанным контактам", pageObject.getErrorText());
    }
    
    @Test
    @DisplayName("Login with empty email field")
    public void testLogin2() {
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputPassword(Users.getUserByEmail().getPassword());
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with empty password field")
    public void testLogin3() {
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail(Users.getUserByEmail().getEmail());
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with empty email and empty password fields")
    public void testLogin4() {
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with invalid email format")
    public void testLogin5() {
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail(Users.getUserByName().getEmail());
        pageObject.inputPassword(Users.getUserByEmail().getPassword());
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }
}
