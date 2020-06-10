package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupTab();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData("Family", null, null);
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().saveFilledGroupForm();
    app.getNavigationHelper().goToGroupTab();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getGroupid(), g2.getGroupid());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
