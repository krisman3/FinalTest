package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PageNames;

import java.time.Duration;


public class LoginTests extends BaseTest {
  @Parameters({"username", "password"})
    @Test
    public void loginTestHappy(String username, String password) {
    System.out.println("////Login test - Happy path ////\n");
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
        loginPage.populateField(loginPage.usernameField, username);
        System.out.println("6. Populate password.");
        loginPage.populateField(loginPage.passwordField, password);
        System.out.println("7. Click Sign in.");
        basePage.clickElement(loginPage.signInBtn);
        System.out.println("8. Check if the login is successful.");
        wait.until(ExpectedConditions.urlToBe(pageNames.HOME_URL));
        basePage.checkURL(pageNames.HOME_URL);

    }
    @Test
    public void loginTestNegative(){
        System.out.println("////Login test - Negative path ////\n");
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
        System.out.println("5. Click on the username and password field without entering any info.");
        LoginPage loginPage = new LoginPage(driver);
        basePage.clickElement(loginPage.usernameField);
        basePage.clickElement(loginPage.passwordField);
        System.out.println("6. Click on Sign in.");
        basePage.clickElement(loginPage.signInBtn);
        System.out.println("7. Check visibility of the toast message.");
        basePage.waitForVisibility(loginPage.toastMsgEmpty);
        System.out.println("8. Verify that the content of the toast message is correct:");
        String errorMsgToast = loginPage.toastMsgEmpty.getText();
        Assert.assertEquals(errorMsgToast, "UsernameOrEmail cannot be empty", "The toast message is incorrect or did not appear.");
    }


}
