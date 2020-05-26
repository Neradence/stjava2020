package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationHelper().goToGroupTab();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToGroupTab();
  }

}
