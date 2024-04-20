package by.itacademy.padaliak.ui.pages;

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
    private By concertsSection = By.xpath("//a[@data-cross-el-content='concert']");
    private By concertName = By.xpath("//div[@class='card-search__content']/div/h2/a[@title='Полина Гагарина']");
    private By buyTicketBtn = By.xpath("//div[@class='show-card__col show-card__col--end']/a[@itemprop='url']");
    private By firstItemInSearch = By.xpath("//div[@class='card-search__head']/h2[@data-js='truncate-text-init']");
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

    public void clickOnConcertsSection(){
        driver.findElement(concertsSection).click();
    }
    public void clickOnConcert(){
        driver.findElement(concertName).click();
    }

    public void clickOnBuyTicketBtn(){
        driver.findElement(buyTicketBtn).click();
    }

    public String getText() {
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
