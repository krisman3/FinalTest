package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends HomePage{

    @FindBy(css = "[formcontrolname='usernameOrEmail']") WebElement usernameField;
    @FindBy(css = "[formcontrolname='password']") WebElement passwordField;
    @FindBy(id = "sign-in-button") WebElement signInBtn;
    @FindBy(css = "a[href='/users/register']") WebElement registerBtn;
    @FindBy(css = "[formcontrolname='rememberMe']") WebElement rememberMeBtn;

public void waitForVisibility(WebElement element){
    wait.until(ExpectedConditions.visibilityOf(element));
}

public void populateField(WebElement element, String content){
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
    element.sendKeys(content);

}
public void checkURL(){
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, LOGIN_URL, "The URL is not the same.");
}
}


