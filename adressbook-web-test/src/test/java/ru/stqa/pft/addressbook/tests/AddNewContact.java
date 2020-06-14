package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.goTo().allContactTab();
    Contacts before = app.contact().allContact();
    System.out.println(before.size());
    app.goTo().addContactTab();
    ContactData contact = new ContactData().withContactname("Nina").withContactsurname("Green").withContactphone("+1 888 888 88").withContactmail("anna@mail.mail").withContactgroup("Colleagues");
    app.contact().fillContactForm(contact);
    app.contact().saveNewContactForm();
    app.goTo().allContactTab();
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().allContact();
    assertThat(after, equalTo(before.withAdded(contact.withContactid(after.stream().mapToInt((c) -> c.getContactid()).max().getAsInt()))));
  }

}
