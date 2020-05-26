package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupTab() {
        click(By.linkText("groups"));
    }

    public void goToAddContactTab() {
        click(By.linkText("add new"));
    }
}
