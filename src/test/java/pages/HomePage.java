package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends HeaderPage {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    String URL = "http://training.skillo-bg.com:4200";
    String HOME_URL = URL + "/posts/all";
    String LOGIN_URL = URL + "/users/login";
    String REG_URL = URL + "/users/register";



    public void clickButton(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
    }
}
