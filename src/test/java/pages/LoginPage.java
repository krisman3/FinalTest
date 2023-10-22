package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends HomePage{
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[formcontrolname='usernameOrEmail']") private WebElement usernameField;
    @FindBy(css = "[formcontrolname='password']") private WebElement passwordField;
    @FindBy(id = "sign-in-button") private WebElement signInBtn;
    @FindBy(css = "a[href='/users/register']") private WebElement registerBtn;
    @FindBy(css = "[formcontrolname='rememberMe']") private WebElement rememberMeBtn;

public void waitForVisibility(WebElement element){
    wait.until(ExpectedConditions.visibilityOf(element));
}

public void populateField(WebElement element, String content){
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
    element.sendKeys(content);
}
    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
public void checkURL(String pageName){
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, pageName, "The URL is not the same.");
}
}


