import PageObjects.LoggedInUserEmailServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailServiceMessageSending extends EmailServiceTestingConfiguration {

    @Test
    public void checkThatEmailMessageCanBeSend() {

        LoggedInUserEmailServicePage newEmail = new LoggedInUserEmailServicePage(driver)
                .clickCreateNewEmailButton()
                .enterEmailTo(mailToUser)
                .enterSubject(emailSubject)
                .enterEmailBody(emailTextMessage)
                .clickSendEmailButton()
                .clickToCloseEmailNotificationMessage();


        Assert.assertTrue(newEmail.isSentMessageDisappearedFromDraft());


        LoggedInUserEmailServicePage sentEmail = new LoggedInUserEmailServicePage(driver)
                .clickSentPageButton();

        Assert.assertEquals(sentEmail.getFistEmailReceiver(), mailToUser);
        Assert.assertEquals(sentEmail.getFistEmailSubject(), emailSubject);
        Assert.assertEquals(sentEmail.getFistEmailBody(), emailTextMessage);

        
    }

}
