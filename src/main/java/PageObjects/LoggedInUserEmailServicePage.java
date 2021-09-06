package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInUserEmailServicePage extends Page {
    private final By userEmailService = By.xpath("//a[@class='gb_C gb_Ma gb_h']");
    private final By userEmailServiceID = By.xpath("//div[@class='gb_nb']");
    private final By writeNewEmailButton = By.xpath("//span[@class='compose-button__txt']");
    private final By sentMessageButton = By.xpath("//div[text()='Отправленные']");
    private final By draftButton = By.xpath("//div[text()='Черновики']");
    private final By lineWithEmailInfo = By.xpath("//div[@class='llc__content']");
    private final By createdNewFolder = By.xpath("//a[text()='TestFolder']");
    private final By mailReceiver = By.xpath("//span[@class='ll-crpt' and @title='WebdriverBasics@yandex.by']");
    private final By mailSubject = By.xpath("//span[@class='llc__subject']/span");
    private final By mailBodyText = By.xpath("//span[@class='ll-sp__normal']");
    private final By successEmailSendNotification = By.xpath("//span[@title='Закрыть']");
    private final By moreEmailOptions = By.xpath("//span[@class='CJ']");
    private final By createTheNewFolderButton = By.xpath("//div[@class='CL Wj']");
    private final By folderNameField = By.xpath("//input[@class='xx']");
    private final By createButton = By.xpath("//button[@name='ok']");


    public LoggedInUserEmailServicePage(WebDriver driver) {
        super(driver);
    }


    public LoggedInUserEmailServicePage clickSentPageButton() {
        waitForElementVisibility(sentMessageButton);
        driver.findElement(sentMessageButton).click();
        return new LoggedInUserEmailServicePage(driver);
    }

    public WriteNewEmailServicePage clickCreateNewEmailButton() {
        waitForElementVisibility(writeNewEmailButton);
        driver.findElement(writeNewEmailButton).click();
        return new WriteNewEmailServicePage(driver);
    }

    public String getUserEmail() {
        waitForElementVisibility(userEmailService);
        driver.findElement(userEmailService).click();
        waitForElementVisibility(userEmailServiceID);
        return driver.findElement(userEmailServiceID).getText();
    }


    public LoggedInUserEmailServicePage clickDraftButton() {
        waitForElementVisibility(draftButton);
        driver.findElement(draftButton).click();
        return new LoggedInUserEmailServicePage(driver);
    }

    public boolean isAnyMailPresent() {
        return !driver.findElements(lineWithEmailInfo).isEmpty();
    }
    public boolean isAnyNewMailFolderPresent() {
        return !driver.findElements(createdNewFolder).isEmpty();
    }

    public boolean isSentMessageDisappearedFromDraft() {
        return driver.findElements(lineWithEmailInfo).isEmpty();
    }


    public String getFistEmailReceiver() {
        return driver.findElement(mailReceiver).getText();
    }

    public String getFistEmailSubject() {
        return driver.findElement(mailSubject).getText();
    }

    public String getFistEmailBody() {
        return driver.findElement(mailBodyText).getText();
    }

    public LoggedInUserEmailServicePage clickToCloseEmailNotificationMessage() {
        waitForElementVisibility(successEmailSendNotification);
        driver.findElement(successEmailSendNotification).click();
        driver.navigate().refresh();
        return new LoggedInUserEmailServicePage(driver);
    }

    public LoggedInUserEmailServicePage createTheNewEmailFolder(String newFolderName) {
        waitForElementVisibility(moreEmailOptions);
        driver.findElement(moreEmailOptions).click();
        waitForElementVisibility(createTheNewFolderButton);
        driver.findElement(createTheNewFolderButton).click();
        driver.findElement(folderNameField).sendKeys(newFolderName);
        waitForElementVisibility(createButton);
        driver.findElement(createButton).click();
        return new LoggedInUserEmailServicePage(driver);


    }


}


