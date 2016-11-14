package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RemoteDriverManager;

import java.util.concurrent.TimeUnit;


import ru.yandex.qatools.allure.annotations.Step;
import utils.WaitsAsserts;

public class CreateISSUE {
        String issueKey = "";
        private WebDriver driver;
        WaitsAsserts waitsAsserts = new WaitsAsserts();


        public CreateISSUE() {
            this.driver = RemoteDriverManager.getDriver();
        }

        @Step("create Bug")
        public void createBug() {
            waitsAsserts.waitForVisibilityByXpath(driver, "//*[@id='create_link']");
            waitsAsserts.waitForClickableByXpath(driver, "//*[@id='create_link']");
            WebElement createButton = driver.findElement(By.xpath("//*[@id='create_link']"));
            createButton.click();

            WebElement issueType = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='issuetype-field']")));

            issueType.clear();
            issueType.sendKeys("Bug");
            issueType.sendKeys(Keys.ENTER);

        }

        @Step("enter project")
        public void enterProject() {
            String projectFieldXpath = "//*[@id=\"project-field\"]";

            waitsAsserts.waitForVisibilityByXpath(driver, projectFieldXpath);
            waitsAsserts.waitForClickableByXpath(driver, projectFieldXpath);

            driver.findElement(By.xpath(projectFieldXpath)).click();
            driver.findElement(By.xpath(projectFieldXpath)).clear();
            driver.findElement(By.xpath(projectFieldXpath)).sendKeys("QAAUT", Keys.ENTER);
        }

        @Step("create summary")
        public void createSummary() {
            waitsAsserts.waitForVisibilityByXpath(driver, "//*[@id='summary']");
            waitsAsserts.waitForClickableByXpath(driver, "//*[@id='summary']");


            WebElement summary = driver.findElement(By.xpath("//*[@id='summary']"));
            summary.clear();
            summary.sendKeys(" This summary was created via WebDriver");

        }

        @Step("create assignee")
        public void createAssignee() {
            WebElement assignee = driver.findElement(By.xpath("//*[@id='assignee-field']"));
            assignee.clear();
            assignee.sendKeys("katherinebilous", Keys.ENTER);

        }

        @Step("get issue key")
        public void getIssueKey() {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            issueKey = driver
                    .findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a"))
                    .getAttribute("data-issue-key");
            System.out.println(issueKey);
        }

        @Step("delete issue")
        public void deleteIssue() {
            driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
            driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
            driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
            driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
        }

    }

