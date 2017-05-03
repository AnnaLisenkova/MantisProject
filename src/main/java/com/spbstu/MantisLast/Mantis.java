package com.spbstu.MantisLast;

import com.spbstu.MantisLast.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anna on 02.05.17.
 */
public class Mantis {
    public static LogInPage loginPage;
    public static CreateTaskPage newTaskPage;
    public static DeleteTask deleteTask;
    public static CheckTask checkTask;
    public static CommonForms commonForms;
    public static TaskReviewPage taskReviewPage;
    public static ReviewPage reviewPage;
    private static WebDriver driver;


    public static void init(WebDriver driver) {
        Mantis.loginPage = PageFactory.initElements(driver, LogInPage.class);
        Mantis.newTaskPage = PageFactory.initElements(driver, CreateTaskPage.class);
        Mantis.deleteTask = PageFactory.initElements(driver, DeleteTask.class);
        Mantis.checkTask = PageFactory.initElements(driver, CheckTask.class);
        Mantis.commonForms = PageFactory.initElements(driver, CommonForms.class);
        Mantis.taskReviewPage = PageFactory.initElements(driver, TaskReviewPage.class);
        Mantis.reviewPage = PageFactory.initElements(driver, ReviewPage.class);
        Mantis.driver = driver;
    }

    public static void open() {
        driver.get("http://127.0.0.1/mantisbt");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
