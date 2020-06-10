package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getContactname());
        type(By.name("lastname"),contactData.getContactsurname());
        type(By.name("home"),contactData.getContactphone());
        type(By.name("email"),contactData.getContactmail());
    }

    public void checkContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void pressDeleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void assertDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void initModifyContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void saveNewContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void saveModifiedContactForm() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public boolean isContactExist() {
        return isPresentElement(By.name("selected[]"));
    }

    public void createContact(ContactData contactData) {
        click(By.linkText("add new"));
        fillContactForm(contactData);
        saveNewContactForm();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int coid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String coname = element.findElement(By.xpath(".//td[3]")).getText();
            String cosurname = element.findElement(By.xpath(".//td[2]")).getText();
            ContactData contact = new ContactData(coid, coname, cosurname, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }

}
