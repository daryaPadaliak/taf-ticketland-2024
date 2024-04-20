package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Login with not registered user")
    public void testLogin1() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("tryrtte@gmail.com");
        pageObject.inputPassword("Password1@");
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Не удалось авторизовать пользователя по указанным контактам", pageObject.getErrorText());
    }
    
    @Test
    @DisplayName("Login with empty email field")
    public void testLogin2() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("");
        pageObject.inputPassword("Password1@");
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with empty password field")
    public void testLogin3() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("543645@gmail.com");
        pageObject.inputPassword("");
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with empty email and empty password fields")
    public void testLogin4() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("");
        pageObject.inputPassword("");
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with invalid email format")
    public void testLogin5() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("7656");
        pageObject.inputPassword("Password1@");
        Assertions.assertEquals("Неправильная почта или пароль", pageObject.getErrorText());
    }

    @Test
    @DisplayName("Login with long email field")
    public void testLogin6() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnLoginBtn();
        pageObject.clickOnEmailBtn();
        pageObject.inputEmail("65456566445876846743657348657834657864357863784657836yftyfyghbjhbewfhkdbvhkjsdfbxvhdfjsbhjdsbvjhdfbvhjdfbvhjdfbv57834657hgfsdhjsgerfhgyeucgnrfrygwefgwuerghncfyuergnfyviruyinvruyd@gmail.com");
        pageObject.inputPassword("Password1@");
        pageObject.clickOnSubmitBtn();
        Assertions.assertEquals("Не удалось авторизовать пользователя по указанным контактам", pageObject.getErrorText());
    }
}
