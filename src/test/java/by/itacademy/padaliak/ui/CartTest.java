package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.page.PageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    @Test
    public void testCart() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.clickOnStandupSection();
        pageObject.clickOnBuyTicketBtn();
        pageObject.clickOnBuyTicketOnMayFirstBtn();
        pageObject.clickOnSeat();
        pageObject.clickOnCheckoutBtn();
        Assertions.assertEquals("StandUp &amp; Action (Cтендап + Джаз концерт)", pageObject.getConcertName());
    }
}
