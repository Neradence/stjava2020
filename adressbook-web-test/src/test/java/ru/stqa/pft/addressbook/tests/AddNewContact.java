package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewContact extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXML() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> groups = (List<ContactData>) xstream.fromXML(xml);
    return groups.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJSON() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJSON")
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
