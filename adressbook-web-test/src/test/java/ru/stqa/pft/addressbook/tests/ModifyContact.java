package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;

public class ModifyContact extends TestBase {

    @Test
    public void testModifyContact() {

        app.getNavigationHelper().goToAllContactTab();
        if (! app.getContactHelper().isContactExist()) {
            app.getContactHelper().createContact(new ContactData("Adam", "Blunt", null, null, null));
            app.getNavigationHelper().goToAllContactTab();
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contactnew = new ContactData(before.get(before.size() - 1).getContactid(), "Tomo", "Kovach", null, null, null);

        app.getContactHelper().initModifyContact(2);
        app.getContactHelper().fillContactForm(contactnew);
        app.getContactHelper().saveModifiedContactForm();
        app.getNavigationHelper().goToAllContactTab();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contactnew);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getContactid(), c2.getContactid());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
