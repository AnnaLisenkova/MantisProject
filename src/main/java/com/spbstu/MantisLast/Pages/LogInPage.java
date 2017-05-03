package com.spbstu.MantisLast.Pages;

import com.spbstu.MantisLast.entities.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 02.05.17.
 */
public class LogInPage {
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    public void fillContactForm(User user){
        this.username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword() + Keys.ENTER);
    }
}
