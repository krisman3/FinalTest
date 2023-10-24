package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageNames;

import java.time.Duration;

public class ForcedFailTest extends BaseTest{

    @Test
    public void navigateToPage(){
        System.out.println("1. Pull up the home page.");
        PageNames pageNames = new PageNames(driver);
        driver.get(pageNames.HOME_URL);
        System.out.println("2. Check if we are on the correct page.");
        BasePage basePage = new BasePage(driver);
        basePage.checkURL(pageNames.HOME_URL);
        System.out.println("3. Make the test fail on purpose");
        Assert.assertTrue(false,"This is a forced fail to test the screenshot.");
    }

}
