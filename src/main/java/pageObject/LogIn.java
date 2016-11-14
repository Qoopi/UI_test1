package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RemoteDriverManager;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WaitsAsserts;


public class LogIn {
    private WebDriver driver;
        WaitsAsserts waits_asserts = new WaitsAsserts();

        public LogIn() {
            this.driver = RemoteDriverManager.getDriver();

        }

        @Step("enter username")
        public void enterLogin() {
            String newTitle = "[VRC-";
            String title = "Log in - JIRA";

            driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
            waits_asserts.assertByTitle(driver, title);
            driver.findElement(By.id("login-form-username")).sendKeys("Geloksmmm");
        }

        @Step("enter password")
        public void enterPassword() {
            driver.findElement(By.id("login-form-password")).sendKeys("Q125478963q");
        }

        @Step("click login")
        public void clickSubmit() {
            driver.findElement(By.id("login-form-submit")).click();
            waits_asserts.waitForClickableByXpath(driver, "//*[@id='logo']/a/img");
        }

    }