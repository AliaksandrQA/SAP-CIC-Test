import PageFactory.LoggedInUserEmailServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailServiceMessageCreation extends EmailServiceTestingConfiguration {
    @Test
    public void checkThatEmailMessageCanBeCreated() {

        LoggedInUserEmailServicePage newEmail = new LoggedInUserEmailServicePage(driver)
                .clickCreateNewEmailButton()
                .enterEmailTo(mailToUser)
                .enterSubject(emailSubject)
                .enterEmailBody(emailTextMessage)
                .clickSaveEmailButton()
                .clickCancelEmailButton()
                .clickDraftButton();


        Assert.assertTrue(newEmail.isAnyMailPresent());


        Assert.assertEquals(newEmail.getFistEmailReceiver(), mailToUser);
        Assert.assertEquals(newEmail.getFistEmailSubject(), emailSubject);
        Assert.assertEquals(newEmail.getFistEmailBody(), emailTextMessage);


    }
}
