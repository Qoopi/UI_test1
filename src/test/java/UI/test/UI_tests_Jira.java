package UI.test;
// test
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LogIn;

import static org.testng.Assert.assertEquals;

public class UI_tests_Jira {

    protected WebDriver driver;

    @BeforeTest
    public void loginSuccessFull() {
        LogIn logIn = new LogIn(driver);
        logIn.enterLogin();
        logIn.enterPassword();
        logIn.clickSubmit();
    }
}