package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver){this.driver = driver;}

    public void createIssue(){
        driver.get("http://soft.it-hillel.com.ua:8080/secure/Dashboard.jspa");
    }

    public void clickCreate(){driver.findElement(By.xpath("//*[@id=\"create_link\"]")).click();}


}

