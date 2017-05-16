package com.spbstu.MantisLast.stepDefs;

import com.spbstu.MantisLast.Mantis;
import com.spbstu.MantisLast.helper.ResourceLoader;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by anna on 02.05.17.
 */
public class MyStepdefs {
    @Given("^Log in as \"([^\"]*)\"$")
    public void logInAs(String userID) throws Throwable {
        Mantis.open();
        Mantis.loginPage.fillContactForm(ResourceLoader.getUser(userID));
        Mantis.commonForms.setProject();
    }

    @And("^Click on CreateTask button on the top$")
    public void clickOnCreateTaskButtonOnTheTop() throws Throwable {
        Mantis.commonForms.pushCreateTaskOnTop();
    }

    @When("^Fill the form with info from \"([^\"]*)\"$")
    public void fillTheFormWithInfoFrom(String taskID) throws Throwable {
        Mantis.newTaskPage.fillTaskForm(ResourceLoader.getTask(taskID));
    }

    @And("^Submit created task$")
    public void submitCreatedTask() throws Throwable {
        Mantis.newTaskPage.submitTaskForm();
    }

    @And("^Open Task List$")
    public void openTaskList() throws Throwable {
        Mantis.commonForms.pushTaskListOnSidebar();
    }

    @And("^Log out$")
    public void logOut() throws Throwable {
        Mantis.commonForms.clickOnUser();
        Mantis.commonForms.clickLogOut();
    }

    @Given("^Open \"([^\"]*)\" review$")
    public void openReview(String taskID) throws Throwable {
        Mantis.taskReviewPage.findAndClickCreatedTask(ResourceLoader.getTask(taskID).getSummary());
    }

    @Then("^Change task status to \"([^\"]*)\"$")
    public void changeTaskStatusTo(String newStatus) throws Throwable {
        Mantis.taskReviewPage.clickOnChangeToField();
        Mantis.taskReviewPage.chooseNewStatus(newStatus);
    }

    @And("^Click on \"([^\"]*)\" button$")
    public void clickOnButton(String button_name) throws Throwable {
        Mantis.taskReviewPage.clickOnChangeToButton(button_name);
    }
    @Then("^Click on \"([^\"]*)\" button at Task Solution Form$")
    public void clickOnButtonAtTaskSolutionForm(String button_name) throws Throwable {
        Mantis.taskReviewPage.clickOnSolveButton(button_name);
    }

    @Given("^Open Review Page$")
    public void openReviewPage() throws Throwable {
        Mantis.commonForms.pushReviewOnSidebar();
    }

    @And("^Click on \"([^\"]*)\"$")
    public void clickOn(String name) throws Throwable {
        Mantis.reviewPage.clickOnRecentlyChangedTasksField();
    }

    @Then("^Task List contains \"([^\"]*)\" with condition \"([^\"]*)\" by \"([^\"]*)\"$")
    public void taskListContainsWithConditionBy(String taskID, String condition, String personInCondition) throws Throwable {
        Assert.assertTrue(Mantis.checkTask.checkCreatedTaskInList(ResourceLoader.getTask(taskID), condition, personInCondition));
    }

    @And("^Task fields contain info from \"([^\"]*)\" with some additional$")
    public void taskFieldsContainInfoFromWithSomeAdditional(String taskID, Map<String,String> addInfo) throws Throwable {
        Assert.assertTrue(Mantis.taskReviewPage
                                .checkTaskFields(ResourceLoader.getTask(taskID),
                                                 addInfo.get("originator"),
                                                 addInfo.get("status"),
                                                 addInfo.get("resolution")));
    }

    @When("^Change responsibility to \"([^\"]*)\"$")
    public void changeResponsibilityTo(String userID) throws Throwable {
        Mantis.taskReviewPage.clickOnListOfResposibleUsers();
        Mantis.taskReviewPage.changeResponsibleUser(userID);
    }
}
