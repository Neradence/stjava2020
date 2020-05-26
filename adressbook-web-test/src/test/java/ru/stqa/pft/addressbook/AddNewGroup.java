package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    goToGroupTab();
    initGroupCreation();
    fillGroupForm(new GroupData("Colleagues", "logo", "This is work group"));
    goToGroupTab();
  }

}
