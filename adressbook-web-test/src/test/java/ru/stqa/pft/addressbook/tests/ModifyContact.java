package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ModifyContact extends TestBase {

    @Test
    public void testModifyContact() {
        app.getNavigationHelper().goToAllContactTab();
        app.getContactHelper().checkContact();
        app.getContactHelper().initModifyContact();
        app.getContactHelper().fillContactForm(new ContactData("Mary", "Black", "9999", "marymail@marymail"));
        app.getContactHelper().saveModifiedContactForm();
        app.getNavigationHelper().goToAllContactTab();
    }
}
