package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class ContactData {
    private int contactid;
    private final String contactname;
    private final String contactsurname;
    private final String contactphone;
    private final String contactmail;
    private final String contactgroup;

    public ContactData(int contactid, String contactname, String contactsurname, String contactphone, String contactmail, String contactgroup) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.contactsurname = contactsurname;
        this.contactphone = contactphone;
        this.contactmail = contactmail;
        this.contactgroup = contactgroup;
    }

    public ContactData(String contactname, String contactsurname, String contactphone, String contactmail, String contactgroup) {
        this.contactid = Integer.MAX_VALUE;
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

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "contactid='" + contactid + '\'' +
                ", contactname='" + contactname + '\'' +
                ", contactsurname='" + contactsurname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(contactname, that.contactname) &&
                Objects.equals(contactsurname, that.contactsurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactname, contactsurname);
    }
}
