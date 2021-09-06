import PageObjects.LoggedInUserEmailServicePage;
import PageObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFolderCreation extends EmailServiceTestingConfiguration {
    @Test
    public void checkThatNewEmailFolderCanBeCreated() {
        LoggedInUserEmailServicePage newFolder = new LoggedInUserEmailServicePage(driver)
                .createTheNewEmailFolder(theNewFolderName);

        Assert.assertTrue(newFolder.isAnyNewMailFolderPresent());
    }


}
