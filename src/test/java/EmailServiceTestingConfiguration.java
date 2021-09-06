import PageObjects.EmailServiceHomePage;
import PageObjects.LoggedInUserEmailServicePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class EmailServiceTestingConfiguration {
    protected static String mailServiceURL = "https://google.com";
    protected static String userMail = "webservice2221@gmail.com";
    protected static String login = "webservice2221";
    protected static String userPassword = "Web_123456_Se";
    protected static String theNewFolderName = "TestFolder";
    protected static String mailToUser = "WebdriverBasics@yandex.by";
    protected static String emailSubject = "For Testing Purposes";
    protected static String emailTextMessage = "Be Set Free Fast";
    protected static By logOutLink = By.xpath("//a[@class='gb_C gb_Ma gb_h']");
    protected static By logOutButton = By.xpath("//a[@class='gb_Cb gb_Tf gb_2f gb_Pe gb_3c']");
    protected static WebDriver driver;


    @BeforeClass(description = "browser launching")
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(mailServiceURL);
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public static void logIn() {
        new EmailServiceHomePage(driver)
                .enterLogin(login)
                .enterPassword(userPassword)
                .goToEmailBox();

    }


    @AfterClass()
    public static void logOut() {
        driver.findElement(logOutLink).click();
        driver.findElement(logOutButton).click();

    }

    @AfterClass(dependsOnMethods = "logOut")
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    public static void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}

