package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToAddContactTab();
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Wait", "+1 888 888 88", "anna@mail.mail", "Colleagues"));
    app.getContactHelper().saveNewContactForm();
    app.getNavigationHelper().goToAddContactTab();
  }

}
