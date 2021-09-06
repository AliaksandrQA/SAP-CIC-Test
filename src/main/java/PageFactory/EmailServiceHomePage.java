package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailServiceHomePage extends Page {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='button svelte-no02r']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement passwordButton;


    public EmailServiceHomePage(WebDriver driver) {
        super(driver);
    }

    public EmailServiceHomePage enterLogin(String login) {
        loginField.sendKeys(login);
        loginButton.click();
        return this;
    }

    public EmailServiceHomePage enterPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
        passwordButton.click();
        return this;

    }
}
