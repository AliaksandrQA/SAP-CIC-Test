package PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected final WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebDriver getDriver(){
        return driver;
    }
    protected void waitForElementVisibility(By locator){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
