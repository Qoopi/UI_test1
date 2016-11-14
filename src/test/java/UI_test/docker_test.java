package UI_test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by gelok on 10.11.2016.
 */
public class docker_test {

        @Test
        public void docTest(){
            URL hostURL = null;
            try {
                hostURL = new URL("http://localhost:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome" );
            capability.setPlatform(Platform.LINUX);
            WebDriver driver = new RemoteWebDriver(hostURL, capability);
            //driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            driver.get("https://google.com");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Random rn = new Random();
            int randInt = rn.nextInt();
            try {
                FileUtils.copyFile(screen, new File("D:/oGGi/scr"+randInt+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("AAAA");
            driver.quit();
        }

    }

