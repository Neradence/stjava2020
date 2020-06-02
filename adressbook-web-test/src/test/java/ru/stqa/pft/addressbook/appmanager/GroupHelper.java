package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.models.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupname());
        type(By.name("group_header"), groupData.getGroupheader());
        type(By.name("group_footer"), groupData.getGroupfooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void saveFilledGroupForm () {
        click(By.name("submit"));
    }

    public void saveModifyGroupForm() {
        click(By.name("update"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void modifySelectGroup() {
        click(By.name("edit"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        saveFilledGroupForm();
    }

    public boolean isGroupExist() {
        return isPresentElement(By.name("selected[]"));
    }
}