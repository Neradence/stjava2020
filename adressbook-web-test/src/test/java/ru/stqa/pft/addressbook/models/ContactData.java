package ru.stqa.pft.addressbook.models;

public class ContactData {
    private final String contactname;
    private final String contactsurname;
    private final String contactphone;
    private final String contactmail;
    private final String contactgroup;

    public ContactData(String contactname, String contactsurname, String contactphone, String contactmail, String contactgroup) {
        this.contactname = contactname;
        this.contactsurname = contactsurname;
        this.contactphone = contactphone;
        this.contactmail = contactmail;
        this.contactgroup = contactgroup;
    }

    public String getContactname() {
        return contactname;
    }

    public String getContactsurname() {
        return contactsurname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public String getContactmail() {
        return contactmail;
    }

    public String getContactgroup() {
        return contactgroup;
    }
}
