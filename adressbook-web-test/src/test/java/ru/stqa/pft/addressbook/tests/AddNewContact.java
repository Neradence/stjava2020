package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToAllContactTab();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToAddContactTab();
    ContactData contact = new ContactData("Anna", "Wait", "+1 888 888 88", "anna@mail.mail", "Colleagues");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().saveNewContactForm();
    app.getNavigationHelper().goToAllContactTab();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setContactid(after.stream().max((Comparator<ContactData>) (contactData, t1) -> Integer.compare(contactData.getContactid(), t1.getContactid())).get().getContactid());
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactid(), c2.getContactid());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
