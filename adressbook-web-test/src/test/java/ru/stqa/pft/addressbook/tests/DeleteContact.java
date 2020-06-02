package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.GroupData;

public class DeleteContact extends TestBase {

    @Test
    public void testDeleteContact() throws Exception {
        app.getNavigationHelper().goToAllContactTab();
        if (! app.getContactHelper().isContactExist()) {
            app.getContactHelper().createContact(new ContactData("Adam", "Blunt", "8888", "bluntmail@mail", null));
            app.getNavigationHelper().goToAllContactTab();
        }
        app.getContactHelper().checkContact();
        app.getContactHelper().pressDeleteContact();
        app.getContactHelper().assertDeleteContact();
        app.getNavigationHelper().goToAllContactTab();
    }
}
