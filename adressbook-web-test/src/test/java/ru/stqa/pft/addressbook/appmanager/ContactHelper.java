package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creationcheck) {
        type(By.name("firstname"),contactData.getContactname());
        type(By.name("lastname"),contactData.getContactsurname());
        type(By.name("home"),contactData.getContactphone());
        type(By.name("email"),contactData.getContactmail());

        if (creationcheck) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getContactgroup());
        } else {
            Assert.assertFalse(isPresentElement(By.name("new_group")));
        }
    }

    public void checkContact() {
        click(By.name("selected[]"));
    }

    public void pressDeleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void assertDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void initModifyContact() {
        click(By.name("selected[]"));
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void saveNewContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void saveModifiedContactForm() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }
}
