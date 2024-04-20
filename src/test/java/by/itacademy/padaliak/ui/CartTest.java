package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    @Test
    public void testCart() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnConcertsSection();
        pageObject.clickOnConcert();
        pageObject.clickOnBuyTicketBtn();
        Assertions.assertEquals("Золушка", pageObject.getText());
    }
}
