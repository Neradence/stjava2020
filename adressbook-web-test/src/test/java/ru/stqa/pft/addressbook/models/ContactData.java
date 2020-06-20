package ru.stqa.pft.addressbook.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    private int contactid = Integer.MAX_VALUE;
    private String contactname;
    private String contactsurname;
    private String contactgroup;
    private String contactphone;
    private String contactmobile;
    private String contactworkphone;
    private String allphones;
    private String email1;
    private String email2;
    private String email3;
    private String allmails;
    private String address;
    private File photo;

    public String getContactname() {
        return contactname;
    }

    public String getContactsurname() {
        return contactsurname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public String getContactmobile() {
        return contactmobile;
    }

    public String getContactworkphone() {
        return contactworkphone;
    }

    public String getContactgroup() {
        return contactgroup;
    }

    public String getAllphones() {
        return allphones;
    }

    public int getContactid() {
        return contactid;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllmails() {
        return allmails;
    }

    public String getAddress() {
        return address;
    }

    public File getPhoto() {
        return photo;
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

    public ContactData withContactgroup(String contactgroup) {
        this.contactgroup = contactgroup;
        return this;
    }

    public ContactData withContactmobile(String contactmobile) {
        this.contactmobile = contactmobile;
        return this;
    }

    public ContactData withContactworkphone(String contactworkphone) {
        this.contactworkphone = contactworkphone;
        return this;
    }

    public ContactData withAllContactPones(String allphones) {
        this.allphones = allphones;
        return this;
    }

    public ContactData withAllContactEmails(String allmails) {
        this.allmails = allmails;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }
    public ContactData withContactaddress(String address) {
        this.address = address;
        return this;
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo;
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
