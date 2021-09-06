package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WriteNewEmailServicePage extends Page {
    @FindBy(xpath = "//input[@class='container--H9L5q size_s--3_M-_']")
    private WebElement mailToLabel;

    @FindBy(name = "Subject")
    private WebElement subjectField;

    @FindBy(xpath = "//span[text()='Сохранить']")
    private WebElement saveToDraftButton;

    @FindBy(xpath = "//span[text()='Отменить']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//div[contains(@class,'editable-container-')]/div")
    private WebElement mailBodyLabel;

    public WriteNewEmailServicePage(WebDriver driver) {
        super(driver);
    }

    public WriteNewEmailServicePage enterEmailTo(String email) {
        mailToLabel.sendKeys(email);
        return this;
    }

    public WriteNewEmailServicePage enterSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }

    public WriteNewEmailServicePage enterEmailBody(String text) {
        mailBodyLabel.clear();
        mailBodyLabel.sendKeys(text);
        return this;
    }

    public WriteNewEmailServicePage clickSaveEmailButton() {
        saveToDraftButton.click();
        return this;
    }

    public LoggedInUserEmailServicePage clickCancelEmailButton() {
        cancelButton.click();
        return new LoggedInUserEmailServicePage(driver);
    }

    public LoggedInUserEmailServicePage clickSendEmailButton() {
        sendEmailButton.click();
        return new LoggedInUserEmailServicePage(driver);

    }
}
