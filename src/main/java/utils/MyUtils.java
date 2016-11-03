package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by gelok on 03.11.2016.
 */
public class MyUtils {
    public void makeScreenshot(String name, WebDriver driver, String date){
        sleep(1000);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("D:/ScreenShots/"+date+"/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void assertByTitle(WebDriver driver, String title){
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, title);
    }
    public void scrollPageUp(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -250);");
    }
    public void waitForVisibilityByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForClickableByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

}
