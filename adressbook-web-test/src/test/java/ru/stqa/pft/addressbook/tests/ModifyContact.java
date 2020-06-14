package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModifyContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().allContactTab();

        if (app.contact().allContact().size() == 0) {
            app.contact().createContact(new ContactData().withContactname("Adam").withContactsurname("Blunt"));
            app.goTo().allContactTab();
        }
    }

    @Test
    public void testModifyContact() {
        Contacts before = app.contact().allContact();
        ContactData modContact = before.iterator().next();
        ContactData contact = new ContactData().withContactid(modContact.getContactid()).withContactname("Tomo").withContactsurname("Kovach");
        app.contact().modifyContact(contact);
        app.goTo().allContactTab();
        assertEquals(app.contact().getContactCount(), before.size());
        Contacts after = app.contact().allContact();
        assertThat(after, equalTo(before.withOut(modContact).withAdded(contact)));
    }


}
