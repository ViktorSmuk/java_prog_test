package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

  public int count() {
    return wd.findElements(By.xpath("//img[@title='Edit']")).size();
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactDate, boolean creation) {
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

  public void selectContactById (int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void acceptDeletionContact() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//input[@value='"+ id +"']/parent::td/following-sibling::td//img[@title='Edit']")).click();
  }


  public void submitContactModification() {
    click(By.name("update"));

  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact, boolean creation) {
    addNewContact();
    fillContactForm(contact, creation);
    contactCache = null;
    returnToContactPage();
  }

  public void modify(ContactData contact) {
   selectContactById(contact.getId());
   initContactModificationById(contact.getId());
   fillContactForm(contact,false);
   submitContactModification();
   contactCache = null;
   returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    acceptDeletionContact();
    contactCache = null;
    returnToContactPage();
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if(contactCache != null){
      return new Contacts (contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      contactCache.add(new ContactData().withId(id).
              withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return contactCache;
  }


  public ContactData infoFormEditForm(ContactData contact) {
  initContactModificationById(contact.getId());
  String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
  String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
  String home = wd.findElement(By.name("home")).getAttribute("value");
  String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
  String work = wd.findElement(By.name("work")).getAttribute("value");
  String email  = wd.findElement(By.name("email")).getAttribute("value");
  String email2 = wd.findElement(By.name("email2")).getAttribute("value");
  String email3 = wd.findElement(By.name("email3")).getAttribute("value");
  String address = wd.findElement(By.name("address")).getText();


  wd.navigate().back();
  return new ContactData().withId(contact.getId()).withFirstname(firstname).
          withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);


  }
}
