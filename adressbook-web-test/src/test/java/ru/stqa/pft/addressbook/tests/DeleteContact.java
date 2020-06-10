package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.List;

public class DeleteContact extends TestBase {

    @Test
    public void testDeleteContact() throws Exception {
        app.getNavigationHelper().goToAllContactTab();
        if (! app.getContactHelper().isContactExist()) {
            app.getContactHelper().createContact(new ContactData("Adam", "Blunt", "8888", "bluntmail@mail", null));
            app.getNavigationHelper().goToAllContactTab();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().checkContact(before.size() - 1);
        app.getContactHelper().pressDeleteContact();
        app.getContactHelper().assertDeleteContact();
        app.getNavigationHelper().goToAllContactTab();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
