package by.itacademy.padaliak.ui.page;

import by.itacademy.padaliak.ui.driver.Driver;
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

    public void openHomePage() {
        driver.get(url);
    }

    public void inputSearch(String query) {
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    public void clickOnStandupSection(){
        driver.findElement(standupSection).click();
    }
    public void clickOnBuyTicketBtn(){
        driver.findElement(buyTicketBtn).click();
    }
    public void clickOnBuyTicketOnMayFirstBtn(){
        driver.findElement(buyTicketOnMayFirstBtn).click();
    }
    public void clickOnSeat(){
        driver.findElement(seat).click();
    }
    public void clickOnCheckoutBtn(){
        driver.findElement(checkoutBtn).click();
    }

    public String getConcertName() {
        WebElement text = driver.findElement(concertName);
        return text.getText();
    }

    public String getSearchText() {
        WebElement text = driver.findElement(firstItemInSearch);
        return text.getText();
    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void clickOnEmailBtn(){
        driver.findElement(emailBtn).click();
    }

    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSubmitBtn(){
        driver.findElement(submitBtn).click();
    }

    public String getErrorText() {
        WebElement text = driver.findElement(errorText);
        return text.getText();
    }
}
