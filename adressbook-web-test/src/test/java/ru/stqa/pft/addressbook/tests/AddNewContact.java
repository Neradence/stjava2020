package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.goToAddContactTab();
    app.fillContactForm(new ContactData("Anna", "Wait", "+1 888 888 88", "anna@mail.mail"));
    app.goToAddContactTab();
  }

}
