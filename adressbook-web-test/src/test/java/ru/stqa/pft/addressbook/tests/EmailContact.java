package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmailContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().allContactTab();

        if (app.contact().allContact().size() == 0) {
            app.contact().createContact(new ContactData().withContactname("Leena").withContactsurname("Brown").withEmail1("mail1@mail").withEmail2("mail2@mail").withEmail3("mail3@mail"));
            app.goTo().allContactTab();
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().allContactTab();
        ContactData contactEm = app.contact().allContact().iterator().next();
        ContactData contactInfoEdit = app.contact().infoEditContact(contactEm);
        assertThat(contactEm.getAllmails(), equalTo(mergeAllMails(contactInfoEdit)));
    }

    private String mergeAllMails(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
    }

}
