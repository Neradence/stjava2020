package ru.stqa.pft.addressbook.tests;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyGroup extends TestBase {

    @Test
    public void testModifyGroup() throws Exception {
        app.getNavigationHelper().goToGroupTab();

        if (! app.getGroupHelper().isGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("Friends", "logo", null));
            app.getNavigationHelper().goToGroupTab();
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().modifySelectGroup();
        GroupData group = new GroupData(before.get(before.size() - 1).getGroupid(), "Sport", "logo-2", "Friends Group");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().saveModifyGroupForm();
        app.getNavigationHelper().goToGroupTab();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getGroupid(), g2.getGroupid());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
