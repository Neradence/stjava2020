package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().allContactTab();

        if (app.contact().allContact().size() == 0) {
            app.contact().createContact(new ContactData().withContactname("Eve").withContactsurname("Pink").withContactaddress("citycity-city city? citys"));
            app.goTo().allContactTab();
        }
    }

    @Test
    public void testFAddressContact() {
        app.goTo().allContactTab();
        ContactData contactFAd = app.contact().allContact().iterator().next();
        ContactData contactInfoEdit = app.contact().infoEditContact(contactFAd);
        assertThat(contactFAd.getAddress(), equalTo(contactInfoEdit.getAddress()));
    }
}
