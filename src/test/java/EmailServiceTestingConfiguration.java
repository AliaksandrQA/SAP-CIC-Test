import PageFactory.EmailServiceHomePage;
import PageFactory.LoggedInUserEmailServicePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class EmailServiceTestingConfiguration {
    protected static String mailServiceURL = "https://mail.ru";
    protected static String userMail = "web_service_2021@mail.ru";
    protected static String login = "web_service_2021";
    protected static String userPassword = "Web_123456_Se";
    protected static String mailToUser = "WebdriverBasics@yandex.by";
    protected static String emailSubject = "For Testing Purposes";
    protected static String emailTextMessage = "Be Set Free Fast";
    protected static By logOutLink = By.xpath("//div[@class='ph-project ph-project__account svelte-lraxop']");
    protected static By logOutButton = By.xpath("//div[text()='Выйти']");
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
                .enterPassword(userPassword);

    }

    @AfterClass()
    public static void clearEmail() {
        new LoggedInUserEmailServicePage(driver).clickSentPageButton()
               .deleteSentEmails();

    }


    @AfterClass()
    public static void logOut() {
        driver.findElement(logOutLink).click();
        driver.findElement(logOutButton).click();
    }

    @AfterClass()
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    public static void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}

