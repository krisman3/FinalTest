package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage{

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

    public void navigateToLogin(){

    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}


