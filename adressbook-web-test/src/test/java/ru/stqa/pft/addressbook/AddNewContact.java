package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    goToAddContactTab();
    fillContactForm(new ContactData("Anna", "Wait", "+1 888 888 88", "anna@mail.mail"));
    goToAddContactTab();
  }

}
