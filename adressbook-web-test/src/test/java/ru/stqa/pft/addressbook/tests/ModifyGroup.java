package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class ModifyGroup extends TestBase {

    @Test
    public void testModifyGroup() throws Exception {
        app.getNavigationHelper().goToGroupTab();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("Friends", "logo", null));
            app.getNavigationHelper().goToGroupTab();
            before = app.getGroupHelper().getGroupCount();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().modifySelectGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Work", "logo-2", "Friends Group"));
        app.getGroupHelper().saveModifyGroupForm();
        app.getNavigationHelper().goToGroupTab();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
