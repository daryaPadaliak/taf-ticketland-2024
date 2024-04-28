package by.itacademy.padaliak.ui.page;

import by.itacademy.padaliak.ui.driver.Driver;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
    private WebDriver driver;

    public PageObject() {
        this.driver = Driver.getDriver();
    }

    private String url = "https://www.ticketland.ru/";
    private By searchField = By.xpath("//input[@class='tl-input__text'][1]");
    private By standupSection = By.xpath("//li[@class='header__menu-link']/a[@data-cross-el-content='standup']");
    private By buyTicketBtn = By.xpath("//div[@class='card-search__right']/a[@title='StandUp & Action (Cтендап + Джаз концерт)']");
    private By buyTicketOnMayFirstBtn = By.xpath("//*[@id=\"list-performances\"]/div[3]/article[1]/div[2]/a");
    private By seat = By.xpath("//*[@id=\"p67650167\"]");
    private By checkoutBtn = By.xpath("//div[@data-js='basket-checkout']/button[@data-js='checkout-btn']");
    private By firstItemInSearch = By.xpath("//div[@class='card-search__head']/h2[@data-js='truncate-text-init']");
    private By concertName = By.xpath("//a[@class='text-h4 tl-text-primary text-bold']");
    private By loginBtn = By.xpath("//img[@alt='Личный кабинет']");
    private By emailBtn = By.xpath("//div[@class='q-mt-md q-mb-md']/div/button[@aria-pressed='false']");
    private By emailField = By.xpath("//input[@placeholder='Ваш email']");
    private By passwordField = By.xpath("//input[@placeholder='Ваш пароль']");
    private By submitBtn = By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--flat q-btn--rectangle text-white q-btn--actionable q-focusable q-hoverable q-btn--no-uppercase full-width bg-primary q-mt-md']");
    private By errorText = By.xpath("//div[@class='q-field__messages col']");
    private static final Logger logger = LogManager.getLogger();

    @Step("Open Home page")
    public void openHomePage() {
        logger.info("Open Home page");
        driver.get(url);
    }

    @Step("Input in Search field")
    public void inputSearch(String query) {
        logger.info("Input in Search field " + query);
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    @Step("Click on StandUp section on Home page")
    public void clickOnStandupSection(){
        logger.info("Click on StandUp section on Home page");
        driver.findElement(standupSection).click();
    }
    @Step("Click on Buy Ticket button near the selected event")
    public void clickOnBuyTicketBtn(){
        logger.info("Click on Buy Ticket button near the selected event");
        driver.findElement(buyTicketBtn).click();
    }
    @Step("Click on Buy Ticket button on the selected date")
    public void clickOnBuyTicketOnMayFirstBtn(){
        logger.info("Click on Buy Ticket button on the selected date");
        driver.findElement(buyTicketOnMayFirstBtn).click();
    }
    @Step("Click on the selected seat")
    public void clickOnSeat(){
        logger.info("Click on the selected seat");
        driver.findElement(seat).click();
    }
    @Step("Click on the checkout button in cart")
    public void clickOnCheckoutBtn(){
        logger.info("Click on the checkout button in cart");
        driver.findElement(checkoutBtn).click();
    }

    @Step("Get concert name")
    public String getConcertName() {
        logger.info("Get concert name");
        WebElement text = driver.findElement(concertName);
        return text.getText();
    }

    @Step("Get search text")
    public String getSearchText() {
        logger.info("Get search text");
        WebElement text = driver.findElement(firstItemInSearch);
        return text.getText();
    }

    @Step("Click on Login button")
    public void clickOnLoginBtn(){
        logger.info("Click on Login button");
        driver.findElement(loginBtn).click();
    }

    @Step("Click on Email button during login")
    public void clickOnEmailBtn(){
        logger.info("Click on Email button during login");
        driver.findElement(emailBtn).click();
    }

    @Step("Input in email field")
    public void inputEmail(String email) {
        logger.info("Input in email field " + email);
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Input in password field")
    public void inputPassword(String password) {
        logger.info("Input in password field " + password);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click on submit button during login")
    public void clickOnSubmitBtn(){
        logger.info("Click on submit button during login");
        driver.findElement(submitBtn).click();
    }

    @Step("Get error text for invalid login")
    public String getErrorText() {
        logger.info("Get error text for invalid login");
        WebElement text = driver.findElement(errorText);
        return text.getText();
    }
}
