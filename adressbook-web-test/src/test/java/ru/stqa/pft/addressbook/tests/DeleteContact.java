package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContact extends TestBase {

    @Test
    public void testDeleteContact() throws Exception {
        app.getNavigationHelper().goToAllContactTab();
        app.getContactHelper().checkContact();
        app.getContactHelper().pressDeleteContact();
        app.getContactHelper().assertDeleteContact();
        app.getNavigationHelper().goToAllContactTab();
    }
}
