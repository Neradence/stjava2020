package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    app.goToGroupTab();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Colleagues", "logo", "This is work group"));
    app.goToGroupTab();
  }

}
