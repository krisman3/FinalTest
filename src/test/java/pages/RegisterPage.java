package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    HeaderPage headerPage = new HeaderPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    @FindBy(css = "[placeholder='Username']")
    private WebElement usernameField;
    @FindBy(css = "[formcontrolname='email']")
    private WebElement emailField;
    @FindBy(css = "[placeholder='Password']")
    private WebElement passwordField;
    @FindBy(css = "[formcontrolname='confirmPassword']")
    private WebElement confirmPassword;
    @FindBy(id = "sign-in-button")
    private WebElement signInBtn;
    //The error message when an invalid email has been entered.
    @FindBy(xpath = "//span[contains(text(), 'Email invalid')]")
    private WebElement invalidEmailMsg;


    public void checkErrorMsg(WebElement element) {
        loginPage.waitForVisibility(element);
        //Capturing the text from the message and verifying it with the expected behavior.
        String invalidMsg = invalidEmailMsg.getText();
        Assert.assertEquals(invalidMsg, "Email invalid!", "The error message is not as expected.");
    }
}


