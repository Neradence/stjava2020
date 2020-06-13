package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

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

    public void checkContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void pressDeleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void assertDeleteContact() {
        wd.switchTo().alert().accept();
    }

    private void initModifyContactById(int contactid) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + contactid + "']")).click();
    }

    public void saveNewContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void saveModifiedContactForm() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void createContact(ContactData contactData) {
        click(By.linkText("add new"));
        fillContactForm(contactData);
        saveNewContactForm();
    }

    public void deleteContact(ContactData delContact) {
        checkContactById(delContact.getContactid());
        pressDeleteContact();
        assertDeleteContact();
    }

    public void modifyContact(ContactData contact) {
        initModifyContactById(contact.getContactid());
        fillContactForm(contact);
        saveModifiedContactForm();
    }

    public Contacts allContact() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int coid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String coname = element.findElement(By.xpath(".//td[3]")).getText();
            String cosurname = element.findElement(By.xpath(".//td[2]")).getText();
            contacts.add(new ContactData().withContactid(coid).withContactname(coname).withContactsurname(cosurname));
        }
        return contacts;
    }

}
