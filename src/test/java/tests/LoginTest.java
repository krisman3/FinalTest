package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PageNames;

import java.time.Duration;


public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void loginTestHappy() {
        System.out.println("1. Navigate to home page.");
        PageNames pageNames = new PageNames(driver);
        driver.get(pageNames.HOME_URL);
        BasePage basePage = new BasePage(driver);
        System.out.println("2. Check if the URL is correct.");
        basePage.checkURL(pageNames.HOME_URL);
        System.out.println("3. Click on Login");
        basePage.clickElement(basePage.loginBtn);
        System.out.println("4. Check if the login page has been opened.");
        wait.until(ExpectedConditions.urlToBe(pageNames.LOGIN_URL));
        basePage.checkURL(pageNames.LOGIN_URL);
        System.out.println("5. Populate username.");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateField(loginPage.usernameField, "auto_user");
        System.out.println("6. Populate password.");
        loginPage.populateField(loginPage.passwordField, "auto_pass");
        System.out.println("7. Click Sign in.");
        basePage.clickElement(loginPage.signInBtn);
        System.out.println("8. Check if the login is successful.");
        wait.until(ExpectedConditions.urlToBe(pageNames.HOME_URL));
        basePage.checkURL(pageNames.HOME_URL);

    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
    }
}
