package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import java.util.List;

public class DeleteGroup extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationHelper().goToGroupTab();

    if (! app.getGroupHelper().isGroupExist()) {
      app.getGroupHelper().createGroup(new GroupData("Friends", "logo", null));
      app.getNavigationHelper().goToGroupTab();
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupTab();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
