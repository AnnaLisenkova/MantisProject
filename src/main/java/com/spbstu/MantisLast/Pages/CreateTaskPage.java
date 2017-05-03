package com.spbstu.MantisLast.Pages;

import com.spbstu.MantisLast.Mantis;
import com.spbstu.MantisLast.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 02.05.17.
 */
public class CreateTaskPage {
    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "category_id")
    WebElement category;

    @FindBy(css = "[name='reproducibility']")
    WebElement reproducibility;

    @FindBy(css = "[name='severity']")
    WebElement influence;

    @FindBy(css = "[name='priority']")
    WebElement priority;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement os;

    @FindBy(id = "os_build")
    WebElement osVersion;

    @FindBy(id = "steps_to_reproduce")
    WebElement reproduceSteps;

    @FindBy(id = "additional_info")
    WebElement additionalInfo;

    @FindBy(id = "handler_id")
    WebElement appointUser;

    @FindBy(css = "input[value='Создать задачу']")
    WebElement submitTaskFormButton;

    public void submitTaskForm(){
        this.submitTaskFormButton.click();
    }


    public void fillTaskForm(Task issue){
        this.category.click();
        Mantis.getDriver().findElement(By.xpath("//option[.='[все проекты] General']")).click();
        //Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+issue.getCategory()+"']")).click();

        this.reproducibility.click();
        Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+issue.getReproducibility()+"']")).click();

        this.influence.click();
        Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+issue.getInfluence()+"']")).click();

        this.priority.click();
        Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+issue.getPriority()+"']")).click();

        this.platform.sendKeys(issue.getPlatform());
        this.os.sendKeys(issue.getOS());
        this.osVersion.sendKeys(issue.getOSVersion());

        this.appointUser.click();
        Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+issue.getOrder()+"']")).click();

        this.summary.sendKeys(issue.getSummary());
        this.description.sendKeys(issue.getDescription());
        this.reproduceSteps.sendKeys(issue.getReproduceSteps());
        this.additionalInfo.sendKeys(issue.getAdditionalInfo());
    }
}
