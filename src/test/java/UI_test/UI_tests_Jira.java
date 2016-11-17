package UI_test;

import org.testng.annotations.Test;
import pageObject.CreateISSUE;
import pageObject.LogIn;
import pageObject.LogOut;
import pageObject.UpdateISSUE;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import utils.MyUtils;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class UI_tests_Jira {
    MyUtils myUtils = new MyUtils();
    String issueKey = "";

        @Test
        public void Login() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();
        }

        @TestCaseId("Functions")
        @Features("CreateIssue")
        @Stories({"SomeStory"})
        @Test(priority = 1)
        public void createIssue() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();

            CreateISSUE createISSUE = new CreateISSUE();
            createISSUE.OpenCreateISSUE();
            createISSUE .createBug();
            createISSUE .enterProject();
            createISSUE .createSummary();
            createISSUE .createAssignee();
            createISSUE .getIssueKey();
            createISSUE .deleteIssue();

            LogOut logOut = new LogOut();
            logOut.logOutOf();

        }

        @TestCaseId("Functions")
        @Features("CreateIssue")
        @Stories({"SomeStory"})
        @Test(groups = {"CreateIssueFunctions"}, priority = 2)
        public void AddComment() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();

            CreateISSUE createISSUE = new CreateISSUE();
            createISSUE.OpenCreateISSUE();
            createISSUE .createBug();
            createISSUE .enterProject();
            createISSUE .createSummary();
            createISSUE .createAssignee();

            UpdateISSUE updateIssuePage = new UpdateISSUE();
            updateIssuePage.getIssueKey();
            updateIssuePage.addComment();
            updateIssuePage.deleteIssue();

            LogOut logOut = new LogOut();
            logOut.logOutOf();

        }

        @TestCaseId("Functions")
        @Features("CreateIssue")
        @Stories({"SomeStory"})
        @Test(groups = {"CreateIssueFunctions"}, priority = 2)
        public void changeReporter() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();

            CreateISSUE createISSUE = new CreateISSUE();
            createISSUE .createBug();
            createISSUE .enterProject();
            createISSUE .createSummary();
            createISSUE .createAssignee();

            UpdateISSUE updateIssuePage = new UpdateISSUE();
            updateIssuePage.getIssueKey();
            updateIssuePage.updateReporter();
            updateIssuePage.deleteIssue();

            LogOut logOut = new LogOut();
            logOut.logOutOf();

        }

        @TestCaseId("Functions")
        @Features("CreateIssue")
        @Stories({"SomeStory"})
        @Test(groups = {"CreateIssueFunctions"}, priority = 2)
        public void changePriority() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();

            CreateISSUE createISSUE = new CreateISSUE();
            createISSUE .createBug();
            createISSUE .enterProject();
            createISSUE .createSummary();
            createISSUE .createAssignee();

            UpdateISSUE updateIssuePage = new UpdateISSUE();
            updateIssuePage.getIssueKey();
            updateIssuePage.updatePriority();
            updateIssuePage.deleteIssue();

            LogOut logOut = new LogOut();
            logOut.logOutOf();

        }


        @TestCaseId("Functions")
        @Features("CreateIssue")
        @Stories({"SomeStory"})
        @Test(groups = {"CreateIssueFunctions"}, priority = 2)
        public void changeTitle() {
            LogIn logIn = new LogIn();
            logIn.enterLogin();
            logIn.enterPassword();
            logIn.clickSubmit();

            CreateISSUE createISSUE = new CreateISSUE();
            createISSUE .createBug();
            createISSUE .enterProject();
            createISSUE .createSummary();
            createISSUE .createAssignee();

            UpdateISSUE updateIssuePage = new UpdateISSUE();
            updateIssuePage.getIssueKey();
            updateIssuePage.updateIssueTitle();
            updateIssuePage.deleteIssue();


            LogOut logOut = new LogOut();
            logOut.logOutOf();
        }
    }





