package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RemoteDriverManager;
import ru.yandex.qatools.allure.annotations.Step;


    public class LogOut {

        private WebDriver driver;

        public LogOut() {
            this.driver = RemoteDriverManager.getDriver();
        }

        @Step("Logout")
        public void logOutOf() {
            driver.get("http://soft.it-hillel.com.ua:8080/secure/Dashboard.jspa");
            WebElement logout = (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header-details-user-fullname']")));
            logout.click();
            driver.findElement(By.xpath("//*[@id='log_out']")).click();

        }

    }