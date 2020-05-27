package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupTab();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Colleagues", "logo", "This is work group"));
    app.getGroupHelper().saveFilledGroupForm();
    app.getNavigationHelper().goToGroupTab();
  }

}
