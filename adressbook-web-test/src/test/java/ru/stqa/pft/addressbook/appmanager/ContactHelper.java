package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    private Contacts contactCache = null;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getContactname());
        type(By.name("lastname"),contactData.getContactsurname());
        type(By.name("home"),contactData.getContactphone());
        type(By.name("mobile"),contactData.getContactmobile());
        type(By.name("work"),contactData.getContactworkphone());
        type(By.name("email"),contactData.getEmail1());
        type(By.name("email2"),contactData.getEmail2());
        type(By.name("email3"),contactData.getEmail3());
        type(By.name("address"),contactData.getAddress());
        attach(By.name("photo"), contactData.getPhoto());
    }

    public ContactData infoEditContact(ContactData contactPh) {
        initModifyContactById(contactPh.getContactid());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String surname = wd.findElement(By.name("lastname")).getAttribute("value");
        String homeph = wd.findElement(By.name("home")).getAttribute("value");
        String mobileph = wd.findElement(By.name("mobile")).getAttribute("value");
        String workph = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withContactid(contactPh.getContactid()).withContactname(name).withContactsurname(surname).withContactphone(homeph).withContactmobile(mobileph).withContactworkphone(workph).withEmail1(email1).withEmail2(email2).withEmail3(email3).withContactaddress(address);
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
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
        contactCache = null;
    }

    public void deleteContact(ContactData delContact) {
        checkContactById(delContact.getContactid());
        pressDeleteContact();
        assertDeleteContact();
        contactCache = null;
    }

    public void modifyContact(ContactData contact) {
        initModifyContactById(contact.getContactid());
        fillContactForm(contact);
        saveModifiedContactForm();
        contactCache = null;
    }

    public Contacts allContact() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int coid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String coname = element.findElement(By.xpath(".//td[3]")).getText();
            String cosurname = element.findElement(By.xpath(".//td[2]")).getText();
            String allContactPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String allContactEmails = element.findElement(By.xpath(".//td[5]")).getText();
            String contactAddress = element.findElement(By.xpath(".//td[4]")).getText();
            contactCache.add(new ContactData().withContactid(coid).withContactname(coname).withContactsurname(cosurname).withAllContactPones(allContactPhones).withAllContactEmails(allContactEmails).withContactaddress(contactAddress));
        }
        return new Contacts(contactCache);
    }
}
