package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    @FindBy(id="nav-link-home") WebElement homeButton;
    @FindBy(id="nav-link-login") WebElement loginButton;
    @FindBy(id="homeIcon") WebElement homeIcon;


    public void clickButton(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
    }
}
