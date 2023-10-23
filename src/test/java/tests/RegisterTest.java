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
import pages.PageNames;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    WebDriverWait wait;

//    @DataProvider(name = "invalidEmails")
//    public Object[][] invalidEmails() {
//        return new Object[][]{
//                {"abv@gmail."},
//                {"abv@"},
//                {"abv.com.com"},
//                {"@gmail.com"},
//                {"abv@gmail,com"},
//                {"ab,v@gmail.com"},
//                {"abv@@gmail.com"},
//                {"abv@gmail..com"},
//                {"a,bv@gmail.com"},
//                {"abv@gmail.c/om"}
//        };
//    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Parameters({"username", "password", "email"})
    @Test
    public void usernameExistsTest(String username, String password, String email) {
        System.out.println("1. Navigate to the register page.");
        PageNames pageNames = new PageNames(driver);
        driver.get(pageNames.REG_URL);
        System.out.println("2. Check if the URL is correct.");
        BasePage basePage = new BasePage(driver);
        basePage.checkURL(pageNames.REG_URL);
        System.out.println("3. Populate the username field");
        RegisterPage registerPage = new RegisterPage(driver);
        basePage.populateField(registerPage.usernameField, username);
        System.out.println("4. Populate the email field");
        basePage.populateField(registerPage.emailField, email);
        System.out.println("5. Populate the password field");
        basePage.populateField(registerPage.passwordField, password);
        System.out.println("6. Populate the Confirm password field.");
        basePage.populateField(registerPage.confirmPassword, password);
        System.out.println("7. Click on Sign In");
        basePage.clickElement(registerPage.signInBtn);
        System.out.println("8. Wait for the toast message 'Registration failed' to pop up");
        wait.until(ExpectedConditions.visibilityOf(registerPage.toastMsgFail));
        System.out.println("9. Verify that the toast message says what it's supposed to.");
        String toastText = registerPage.toastMsgFail.getText();
        Assert.assertEquals(toastText, "Username taken", "The toast message is incorrect.");
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
    }

}
