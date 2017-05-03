package com.spbstu.MantisLast;

import com.spbstu.MantisLast.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna on 02.05.17.
 */
public class CheckTask {

    @FindAll({@FindBy(xpath = "//td[@class='column-summary']")})
    List<WebElement> elements;

    public  List<WebElement> getList(){
        return elements;
    }

    public boolean checkCreatedTaskInList(Task task, String condition, String personInCondition) {
        return (elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-category']"))
                        .getText()
                        .equals(task.getCategory())))
                |elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-severity']"))
                        .getText()
                        .equals(task.getInfluence())))
                |elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-status']"))
                        .getText()
                        .equals(condition)))
                |elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-status']"))
                        .getText()
                        .equals(personInCondition)))
                |elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-summary']"))
                        .getText()
                        .equals(task.getSummary()))
                ));
    }

    public boolean checkWhetherTaskContainsInList(String expected) {
        return elements.stream()
                .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-summary']"))
                        .getText()
                        .equals(expected)));
    }
}