package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class ModifyGroup extends TestBase {

    @Test
    public void testModifyGroup() throws Exception {
        app.getNavigationHelper().goToGroupTab();
        if (! app.getGroupHelper().isGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("Friends", "logo", null));
            app.getNavigationHelper().goToGroupTab();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().modifySelectGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Work", "logo-2", "Friends Group"));
        app.getGroupHelper().saveModifyGroupForm();
        app.getNavigationHelper().goToGroupTab();
    }
}
