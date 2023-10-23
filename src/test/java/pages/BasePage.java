package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    //The webdriver and wait are just instantiated here. They will be specified later in the test.
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "homeIcon")
    public WebElement homeIcon;

    @FindBy(id = "nav-link-home")
    public WebElement homeBtn;

    @FindBy(id = "nav-link-login")
    public WebElement loginBtn;
    @FindBy(id = "nav-link-new-post")
    public WebElement newPostBtn;

    @FindBy(css = ".fa-sign-out-alt")
    public WebElement signOutBtn;
    @FindBy(id = "search-bar")
    public WebElement searchBar;

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void populateField(WebElement element, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.sendKeys(content);
    }

    public void checkURL(String pageName) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, pageName, "The URL is not the same.");
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
