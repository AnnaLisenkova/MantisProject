package com.spbstu.MantisLast.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 03.05.17.
 */
public class ReviewPage {
    @FindBy(xpath = "//div[@id='recent_mod']/div/h4/a[.='Недавно измененные (30 Дней)']")
    WebElement recentlyChangedTasksField;

    public void clickOnRecentlyChagedTasksField() {
        this.recentlyChangedTasksField.click();
    }
}
