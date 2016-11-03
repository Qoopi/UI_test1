package UI.test;
// test
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LogIn;
import utils.MyUtils;

import static org.testng.Assert.assertEquals;

public class UI_tests_Jira {
    MyUtils myUtils = new MyUtils();

    protected WebDriver driver;

    @BeforeTest
    public void loginSuccessFull() {
        LogIn logIn = new LogIn(driver);
        logIn.openLogInPage();
        logIn.enterLogin();
        logIn.enterPassword();
        logIn.clickSubmit();
    }
}