package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.goToGroupTab();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.goToGroupTab();
  }

}
