package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupTab() {
        if (isPresentElement(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isPresentElement(By.name("New"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void addContactTab() {
        click(By.linkText("add new"));
    }

    public void allContactTab() {
        if (isPresentElement(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

}
