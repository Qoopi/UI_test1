package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {

    private WebDriver driver;
    public LogIn(WebDriver driver){this.driver = driver;}

    public void openLogInPage(){
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
    }

    public void enterLogin(){
        driver.findElement(By.xpath("//input[@id='login-form-username']")).sendKeys("Geloksmmm");
    }
    public  void enterPassword(){
        driver.findElement(By.xpath("//input[@id='login-form-password']")).sendKeys("Q125478963q");
    }
    public void clickSubmit(){
        driver.findElement(By.xpath("//input[@id='login-form-submit']")).click();
    }
}
