package pageObject;

/**
 * Created by gelok on 03.11.2016.
 */

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogOut {

    private WebDriver driver;

    public LogOut(WebDriver driver) {
        this.driver = driver;
    }


    public void LogOutOf() {
        driver.get("http://soft.it-hillel.com.ua:8080/secure/Dashboard.jspa");
        WebElement logout = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header-details-user-fullname']")));

        logout.click();
        driver.findElement(By.xpath("//*[@id='log_out']")).click();

    }

}
