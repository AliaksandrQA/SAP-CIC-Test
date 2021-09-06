package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WriteNewEmailServicePage extends Page {
    private final By mailToLabel = By.xpath("//input[@class='container--H9L5q size_s--3_M-_']");
    private final By subjectField = By.name("Subject");
    private final By saveToDraftButton = By.xpath("//span[text()='Сохранить']");
    private final By cancelButton = By.xpath("//span[text()='Отменить']");
    private final By sendEmailButton = By.xpath("//span[text()='Отправить']");
    private final By mailBodyLabel = By.xpath("//div[contains(@class,'editable-container-')]/div");


    public WriteNewEmailServicePage(WebDriver driver) {
        super(driver);
    }

    public WriteNewEmailServicePage enterEmailTo(String email) {
        waitForElementVisibility(mailToLabel);
        driver.findElement(mailToLabel).sendKeys(email);
        return this;
    }

    public WriteNewEmailServicePage enterSubject(String subject) {
        waitForElementVisibility(subjectField);
        driver.findElement(subjectField).sendKeys(subject);
        return this;
    }

    public WriteNewEmailServicePage enterEmailBody(String text) {
        waitForElementVisibility(mailBodyLabel);
        driver.findElement(mailBodyLabel).clear();
        driver.findElement(mailBodyLabel).sendKeys(text);
        return this;
    }

    public WriteNewEmailServicePage clickSaveEmailButton() {
        waitForElementVisibility(saveToDraftButton);
        driver.findElement(saveToDraftButton).click();

        return this;
    }

    public LoggedInUserEmailServicePage clickCancelEmailButton() {
        waitForElementVisibility(cancelButton);
        driver.findElement(cancelButton).click();
        return new LoggedInUserEmailServicePage(driver);
    }


    public LoggedInUserEmailServicePage clickSendEmailButton() {
        waitForElementVisibility(sendEmailButton);
        driver.findElement(sendEmailButton).click();
        return new LoggedInUserEmailServicePage(driver);
    }


}

