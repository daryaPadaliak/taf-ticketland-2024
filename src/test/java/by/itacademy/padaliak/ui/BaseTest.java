package by.itacademy.padaliak.ui;

import by.itacademy.padaliak.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void tearDown(){
        Driver.quitDriver();
    }
}
