package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class ModifyGroup extends TestBase {

    @Test
    public void testModifyGroup() throws Exception {
        app.getNavigationHelper().goToGroupTab();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().modifySelectGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Friends", "logo-2", "Friends Group"));
        app.getGroupHelper().saveModifyGroupForm();
        app.getNavigationHelper().goToGroupTab();
    }
}
