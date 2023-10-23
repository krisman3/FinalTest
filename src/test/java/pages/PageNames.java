package pages;

import org.openqa.selenium.WebDriver;

public class PageNames extends BasePage {

    public final String URL = "http://training.skillo-bg.com:4200";
    public final String HOME_URL = URL + "/posts/all";
    public final String LOGIN_URL = URL + "/users/login";
    public final String REG_URL = URL + "/users/register";


    public PageNames(WebDriver driver) {
        super(driver);
    }
}

