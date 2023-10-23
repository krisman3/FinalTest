package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;



    @FindBy(css = "[formcontrolname='usernameOrEmail']")
    public WebElement usernameField;

    @FindBy(css = "[formcontrolname='password']")
    public WebElement passwordField;
    @FindBy(id = "sign-in-button")
    public WebElement signInBtn;
    @FindBy(css = "a[href='/users/register']")
    public WebElement registerBtn;
    @FindBy(css = "[formcontrolname='rememberMe']")
    public WebElement rememberMeBtn;

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void populateField(WebElement element, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.sendKeys(content);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void checkURL(String pageName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, pageName, "The URL is not the same.");
    }
    public void checkURLtoBe(String pageName){
        wait.until(ExpectedConditions.urlToBe(pageName));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, pageName, "The expected URL to be is not the same.");
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

}


