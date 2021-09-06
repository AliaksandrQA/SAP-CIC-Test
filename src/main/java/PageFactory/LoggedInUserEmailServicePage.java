package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoggedInUserEmailServicePage extends Page {
    @FindBy(xpath = "//span[@class='ph-project__user-name svelte-lraxop']")
    private WebElement userEmailService;

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeNewEmailButton;

    @FindBy(xpath = "//div[text()='Отправленные']")
    private WebElement sentMessageButton;

    @FindBy(xpath = "//div[text()='Черновики']")
    private WebElement draftButton;

    @FindBy(xpath = "//div[@class='llc__content']")
    private List<WebElement> lineWithEmailInfo;

    @FindBy(xpath = "//span[@class='ll-crpt' and @title='WebdriverBasics@yandex.by']")
    private WebElement mailReceiver;

    @FindBy(xpath = "//span[@class='llc__subject']/span")
    private WebElement mailSubject;

    @FindBy(xpath = "//span[@class='ll-sp__normal']")
    private WebElement mailBodyText;

    @FindBy(xpath = "//span[@title='Закрыть']")
    private WebElement successEmailSendNotification;

    @FindBy(xpath = "//div[@class='ph-project ph-project__account svelte-lraxop']")
    private WebElement logoutLink;

    @FindBy(xpath = "//span[text()='Выделить все']")
    private WebElement sentButtonHighlighter;

    @FindBy(xpath = "//span[text()='Удалить']")
    private WebElement deleteDraftsButton;

    @FindBy(xpath = "//span[text()='Выделить все']")
    private WebElement highlightButton;

    @FindBy(xpath = "//span[text()='Выделить все']")
    private WebElement sentMessagesButtonHighlighter;

    @FindBy(xpath = "//span[@class='button2__wrapper']")
    private WebElement deleteSentMessagesButton;

    public LoggedInUserEmailServicePage(WebDriver driver) {
        super(driver);
    }

    public LoggedInUserEmailServicePage clickSentPageButton() {
        sentMessageButton.click();
        return new LoggedInUserEmailServicePage(driver);
    }

    public WriteNewEmailServicePage clickCreateNewEmailButton() {
        writeNewEmailButton.click();
        return new WriteNewEmailServicePage(driver);
    }

    public String getUserEmail() {
        return userEmailService.getText();
    }

    public LoggedInUserEmailServicePage clickDraftButton() {
        draftButton.click();
        return new LoggedInUserEmailServicePage(driver);
    }

    public boolean isAnyMailPresent() {
        return lineWithEmailInfo != null && lineWithEmailInfo.size() > 0;
    }


    public boolean isSentMessageDisappearedFromDraft() {
        return lineWithEmailInfo.size() == 0;
    }

    public String getFistEmailReceiver() {
        return mailReceiver.getText();
    }

    public String getFistEmailSubject() {
        return mailSubject.getText();
    }

    public String getFistEmailBody() {
        return mailBodyText.getText();
    }

    public LoggedInUserEmailServicePage clickToCloseEmailNotificationMessage() {

        successEmailSendNotification.click();
        driver.navigate().refresh();
        return new LoggedInUserEmailServicePage(driver);
    }

    public void deleteSentEmails() {
        if (sentMessagesButtonHighlighter.isSelected()) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sentMessagesButtonHighlighter));
            sentMessagesButtonHighlighter.click();
            deleteSentMessagesButton.click();
        }


    }


}


