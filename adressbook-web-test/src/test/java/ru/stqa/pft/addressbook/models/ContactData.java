package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class ContactData {
    private int contactid = Integer.MAX_VALUE;
    private String contactname;
    private String contactsurname;
    private String contactphone;
    private String contactmail;
    private String contactgroup;

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

    public ContactData withContactid(int contactid) {
        this.contactid = contactid;
        return this;
    }

    public ContactData withContactname(String contactname) {
        this.contactname = contactname;
        return this;
    }

    public ContactData withContactsurname(String contactsurname) {
        this.contactsurname = contactsurname;
        return this;
    }

    public ContactData withContactphone(String contactphone) {
        this.contactphone = contactphone;
        return this;
    }

    public ContactData withContactmail(String contactmail) {
        this.contactmail = contactmail;
        return this;
    }

    public ContactData withContactgroup(String contactgroup) {
        this.contactgroup = contactgroup;
        return this;
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
        return contactid == that.contactid &&
                Objects.equals(contactname, that.contactname) &&
                Objects.equals(contactsurname, that.contactsurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactid, contactname, contactsurname);
    }
}
