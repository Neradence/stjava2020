package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.List;

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

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void modifySelectGroup() {
        click(By.name("edit"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        saveFilledGroupForm();
    }

    public void modifyGroup(GroupData group) {
        selectGroupById(group.getGroupid());
        modifySelectGroup();
        fillGroupForm(group);
        saveModifyGroupForm();
    }

    public void deleteGroup(GroupData delGroup) {
        selectGroupById(delGroup.getGroupid());
        deleteSelectedGroup();
    }

    public Groups allGroup() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            groups.add(new GroupData().withGroupid(id).withGroupname(name));
        }
        return groups;
    }

}