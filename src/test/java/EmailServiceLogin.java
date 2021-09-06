import PageFactory.LoggedInUserEmailServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailServiceLogin extends EmailServiceTestingConfiguration{
    @Test
    public void registeredUserShouldBeAbleToLogIn() {


        Assert.assertEquals(new LoggedInUserEmailServicePage(driver).getUserEmail(), userMail);
    }
}

