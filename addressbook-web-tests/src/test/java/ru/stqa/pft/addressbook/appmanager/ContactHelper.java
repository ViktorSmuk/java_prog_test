package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[@name='submit'][2]"));
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getHomePhone());
    type(By.name("email"), contactDate.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void acceptDeletionContact() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@title='Edit']"));
  }


  public void submitContactModification() {
    click(By.name("update"));

  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactDate contact, boolean creation) {
    addNewContact();
    fillContactForm(contact, creation);
    returnToContactPage();
  }

  public List<ContactDate> getContactList() {
    List<ContactDate> contacts = new ArrayList<ContactDate>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactDate contact = new ContactDate(id, firstname, lastname, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

}
