package com.spbstu.MantisLast.Pages;

import com.spbstu.MantisLast.Mantis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 02.05.17.
 */
public class CommonForms {
    @FindBy(css = "span[class='user-info']")
    WebElement userSpan;

    @FindBy(css = "[class='ace-icon fa fa-sign-out']")
    WebElement logOut;

    @FindBy(xpath = "//i[@class='fa fa-edit']")
    WebElement buttonCreateTaskOnTop;

    @FindBy(xpath = "//div[@id='sidebar']//li[2]//span")
    WebElement buttonTaskListOnSidebar;

    @FindBy(xpath = "//div[@id='sidebar']//li[1]//span")
    WebElement buttonReviewOnSidebar;

    @FindBy(xpath = "//li[@class='grey']/a[1]")
    WebElement chooseProjectSpan;

    public void clickOnUser(){
        this.userSpan.click();
    }

    public void clickLogOut(){
        this.logOut.click();
    }

    public void pushCreateTaskOnTop(){
        this.buttonCreateTaskOnTop.click();
    }

    public void pushTaskListOnSidebar(){
        this.buttonTaskListOnSidebar.click();
    }

    public void pushReviewOnSidebar() { this.buttonReviewOnSidebar.click(); }

    public void setProject(){
        this.chooseProjectSpan.click();
        Mantis.getDriver().findElement(By.xpath("//ul[@class='list dropdown-yellow no-margin']/li/a[.=' MantisTesting ']")).click();
    }

}
