package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage extends BasePage{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "[placeholder='Username']")
    public WebElement usernameField;
    @FindBy(css = "[formcontrolname='email']")
    public WebElement emailField;
    @FindBy(css = "[placeholder='Password']")
    public WebElement passwordField;
    @FindBy(css = "[formcontrolname='confirmPassword']")
    public WebElement confirmPassword;
    @FindBy(id = "sign-in-button")
    public WebElement signInBtn;
    //The error message when an invalid email has been entered.
    @FindBy(xpath = "//span[contains(text(), 'Email invalid')]")
    public WebElement invalidEmailMsg;
    @FindBy(css = "[aria-label='Username taken']")
    public WebElement toastMsgFail;
    @FindBy(xpath = "//span[contains(text(), 'Passwords do not match!')]")
    public WebElement passwordMismatchText;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkErrorMsg(WebElement element) {
        BasePage basePage = new BasePage(driver);
        basePage.waitForVisibility(element);
        //Capturing the text from the message and verifying it with the expected behavior.
        String invalidMsg = invalidEmailMsg.getText();
        Assert.assertEquals(invalidMsg, "Email invalid!", "The error message is not as expected.");
    }

}


