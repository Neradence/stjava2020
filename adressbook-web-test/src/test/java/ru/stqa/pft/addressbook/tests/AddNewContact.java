package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewContact extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withContactname(split[0]).withContactsurname(split[1]).withContactaddress(split[2]).withEmail1(split[3]).withContactphone(split[4])});
      line = reader.readLine();
    }

    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testAddNewContact(ContactData contact) throws Exception {
    app.goTo().allContactTab();
    Contacts before = app.contact().allContact();
    app.goTo().addContactTab();
    app.contact().fillContactForm(contact);
    app.contact().saveNewContactForm();
    app.goTo().allContactTab();
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().allContact();
    assertThat(after, equalTo(before.withAdded(contact.withContactid(after.stream().mapToInt((c) -> c.getContactid()).max().getAsInt()))));
  }

}
