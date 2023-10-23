package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    LoginPage loginPage = new LoginPage(driver);

    @FindBy(id = "homeIcon")
    private WebElement homeIcon;

    @FindBy(id = "nav-link-home")
    private WebElement homeBtn;

    @FindBy(id = "nav-link-login")
    private WebElement loginBtn;
    @FindBy(id = "nav-link-new-post")
    private WebElement newPostBtn;

    @FindBy(css = ".fa-sign-out-alt")
    private WebElement signOutBtn;
    @FindBy(id = "search-bar")
    private WebElement searchBar;

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
   public void populateElement(WebElement element, String content){
        clickElement(element);
        loginPage.populateField(element, content);
   }

}
