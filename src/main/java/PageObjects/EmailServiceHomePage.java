package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailServiceHomePage extends Page {
    private final By signInButton = By.xpath("//a[@class='gb_3 gb_4 gb_9d gb_3c']");
    private final By emailField = By.xpath("//input[@type='email']");
    private final By passwordField = By.name("password");
    private final By clickNextButton = By.xpath("//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']");
    private final By clickToEmailBoxButton = By.xpath("//div[@class='gb_g gb_h']");

    public EmailServiceHomePage(WebDriver driver) {
        super(driver);
    }

    public EmailServiceHomePage enterLogin(String login) {
        waitForElementVisibility(signInButton);
        driver.findElement(signInButton).click();
        waitForElementVisibility(emailField);
        driver.findElement(emailField).sendKeys(login);
        driver.findElement(clickNextButton).click();
        return this;
    }

    public EmailServiceHomePage enterPassword(String password) {
        waitForElementVisibility(passwordField);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(clickNextButton).click();
        return this;
    }

    public EmailServiceHomePage goToEmailBox( ){
        waitForElementVisibility(clickToEmailBoxButton);
        driver.findElement(clickToEmailBoxButton).click();
        return this;
    }

}