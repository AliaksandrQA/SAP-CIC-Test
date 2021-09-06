package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LoggedInUserEmailServicePage extends Page {
    private final By userEmailService = By.xpath("//a[@class='gb_C gb_Ma gb_h']");
    private final By userEmailServiceID = By.xpath("//div[@class='gb_nb']");
    private final By createdNewFolder = By.xpath("//a[text()='TestFolder']");
    private final By moreEmailOptions = By.xpath("//span[@class='CJ']");
    private final By createTheNewFolderButton = By.xpath("//div[@class='CL Wj']");
    private final By folderNameField = By.xpath("//input[@class='xx']");
    private final By createButton = By.xpath("//button[@name='ok']");


    public LoggedInUserEmailServicePage(WebDriver driver) {
        super(driver);
    }


    public String getUserEmail() {
        waitForElementVisibility(userEmailService);
        driver.findElement(userEmailService).click();
        waitForElementVisibility(userEmailServiceID);
        return driver.findElement(userEmailServiceID).getText();
    }


    public boolean isAnyNewMailFolderPresent() {
        return !driver.findElements(createdNewFolder).isEmpty();
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

    public static void primitiveSorting() {
        List<String> list = new ArrayList<>();
        list.add("Sesquipedalianism");
        list.add("Tsktsk");
        list.add("Euouae");
        list.add("Strengths");
        list.add("subdermatoglyphic ");
        list.add("Incomprehensibilities");
        list.add("Antidisestablishmentarianism");
        list.add("Pseudopseudohypoparathyroidism");
        list.add("Caamp");
        list.add("Cat");
        Stream stream = list.stream();
        stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);
    }

}


