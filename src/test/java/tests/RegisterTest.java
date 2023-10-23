package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageNames;
import pages.RegisterPage;

public class RegisterTest {
    WebDriver driver;

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

    }

    @Test
    public void registerTest() {
        // Going to the register page and checking if it's loaded.
        PageNames homePage = new PageNames(driver);
        driver.get(homePage.REG_URL);

        BasePage basePage = new BasePage(driver);
        basePage.checkURL(homePage.REG_URL);
        // Populate the email field.
        RegisterPage registerPage = new RegisterPage(driver);
        basePage.populateField(registerPage.emailField, "@@abv.bg");
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
    }

}
