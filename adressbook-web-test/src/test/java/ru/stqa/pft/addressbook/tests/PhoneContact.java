package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().allContactTab();

        if (app.contact().allContact().size() == 0) {
            app.contact().createContact(new ContactData().withContactname("Anne").withContactsurname("Yellow").withContactphone("1234").withContactmobile("5678").withContactworkphone("9012"));
            app.goTo().allContactTab();
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().allContactTab();
        ContactData contactPh = app.contact().allContact().iterator().next();
        ContactData contactInfoEdit = app.contact().infoEditContact(contactPh);
        assertThat(contactPh.getAllphones(), equalTo(mergeAllPones(contactInfoEdit)));
    }

    private String mergeAllPones(ContactData contact) {
        return Arrays.asList(contact.getContactphone(), contact.getContactmobile(), contact.getContactworkphone()).stream().filter((s) -> ! s.equals("")).map(PhoneContact::cleanPhone).collect(Collectors.joining("\n"));
    }

    public static String cleanPhone(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
