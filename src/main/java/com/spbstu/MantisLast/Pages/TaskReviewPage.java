package com.spbstu.MantisLast.Pages;

import com.spbstu.MantisLast.Mantis;
import com.spbstu.MantisLast.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 03.05.17.
 */
public class TaskReviewPage {
    @FindBy(xpath = "//select[@name='new_status'][1]")
    WebElement changeToField;

    @FindBy(xpath = "//td[@class='bug-reporter']")
    WebElement reporter;

    @FindBy(xpath = "//td[@class='bug-assigned-to']")
    WebElement bugAssignedTo;

    @FindBy(xpath = "//td[@class='bug-reproducibility']")
    WebElement bugReproducibility;

    @FindBy(xpath = "//td[@class='bug-severity']")
    WebElement bugSeverity;

    @FindBy(xpath = "//td[@class='bug-priority']")
    WebElement priority;

    @FindBy(xpath = "//td[@class='bug-platform']")
    WebElement bugPlatform;

    @FindBy(xpath = "//td[@class='bug-os']")
    WebElement bugOs;

    @FindBy(xpath = "//td[@class='bug-os-version']")
    WebElement bugOsVersion;

    @FindBy(xpath = "//td[@class='bug-status']")
    WebElement bugStatus;

    @FindBy(xpath = "//td[@class='bug-summary']")
    WebElement bugSummary;

    @FindBy(xpath = "//td[@class='bug-description']")
    WebElement bugDescription;

    @FindBy(xpath = "//td[@class='bug-steps-to-reproduce']")
    WebElement bugStepsToReproduce;

    @FindBy(xpath = "//td[@class='bug-additional-information']")
    WebElement bugAdditionalInformation;

    @FindBy(xpath = "//td[@class='bug-resolution']")
    WebElement bugResolution;

    @FindBy(xpath = "//select[@name='handler_id']")
    WebElement responsible;

    public void clickOnChangeToField(){
        this.changeToField.click();
    }

    public void chooseNewStatus(String status){
        Mantis.getDriver().findElement(By.xpath(" //select[@name='new_status'][1]/option[.='"+status+"']")).click();
    }

    public void clickOnChangeToButton(String changeToButton){
        Mantis.getDriver().findElement(By.xpath(" //input[@value='"+changeToButton+"']")).click();
    }

    public void clickOnSolveButton(String buttonName){
        Mantis.getDriver().findElement(By.xpath(" //input[@value='"+buttonName+"']")).click();
    }

    public void clickOnListOfResposibleUsers(){
        this.responsible.click();
    }

    public void changeResponsibleUser(String userID){
        Mantis.getDriver().findElement(By.xpath("//select[@name='handler_id']/option[.='"+userID+"']")).click();
    }

    public void findAndClickCreatedTask(String expected) throws Exception {
        Mantis.checkTask.getList().stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(expected))
                .findFirst()
                .orElseThrow(Exception :: new)
                .findElement(By.xpath("//td[@class='column-id']/a"))
                .click();
    }

    public boolean checkTaskFields(Task task, String originator, String bugStatus, String resolution) {
        return (this.reporter.getText().equals(originator)&&
                this.bugAssignedTo.getText().equals(task.getOrder())&&
                this.bugReproducibility.getText().equals(task.getReproducibility())&&
                this.bugSeverity.getText().equals(task.getInfluence())&&
                this.priority.getText().equals(task.getPriority())&&
                this.bugPlatform.getText().equals(task.getPlatform())&&
                this.bugOs.getText().equals(task.getOS())&&
                this.bugOsVersion.getText().equals(task.getOSVersion())&&
                this.bugStatus.getText().contains(bugStatus)&&
                this.bugSummary.getText().contains(task.getSummary())&&
                this.bugDescription.getText().equals(task.getDescription())&&
                this.bugStepsToReproduce.getText().equals(task.getReproduceSteps())&&
                this.bugAdditionalInformation.getText().equals(task.getAdditionalInfo())&&
                this.bugResolution.getText().equals(resolution));
    }
}
