package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    @Test
    public void testSearch() {
        PageObject pageObject = new PageObject();
        pageObject.openHomePage();
        pageObject.inputSearch("Золушка");
        Assertions.assertEquals("Золушка", pageObject.getText());
    }
}
