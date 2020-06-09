package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupTab();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Family", null, null));
    app.getGroupHelper().saveFilledGroupForm();
    app.getNavigationHelper().goToGroupTab();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
