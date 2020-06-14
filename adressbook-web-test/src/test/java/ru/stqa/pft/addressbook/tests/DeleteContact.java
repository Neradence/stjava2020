package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().allContactTab();

        if (app.contact().allContact().size() == 0) {
            app.contact().createContact(new ContactData().withContactname("Katya").withContactsurname("Blunt").withContactphone("8888").withEmail1("bluntmail@mail"));
            app.goTo().allContactTab();
        }

    }

    @Test
    public void testDeleteContact() throws Exception {
        Contacts before = app.contact().allContact();
        ContactData delContact = before.iterator().next();
        app.contact().deleteContact(delContact);
        app.goTo().allContactTab();
        assertEquals(app.contact().getContactCount(), before.size() - 1);
        Contacts after = app.contact().allContact();
        assertThat(after, equalTo(before.withOut(delContact)));
    }


}
