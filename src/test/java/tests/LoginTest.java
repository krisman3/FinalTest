package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.net.URL;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    private final String  URL = "http://training.skillo-bg.com:4200";
    private final String HOME_URL = URL + "/posts/all";
    private final String LOGIN_URL = URL + "/users/login";
    private final String REG_URL = URL + "/users/register";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void loginTest(){
    driver.get(URL);
//    LoginPage loginPage = new LoginPage(driver);
//    loginPage.checkURL(URL);
//    loginPage.clickElement();
    }

    @AfterMethod
    public void cleanUp(){

    }
}
