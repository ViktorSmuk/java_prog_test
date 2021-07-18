package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase{

  public ContactHelper (FirefoxDriver wd){
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("Logout"));
  }

  public void submitContactCreation() {
    click(By.linkText("home"));
  }

    public void fillContactForm(ContactDate contactDate) {
    type(By.name("firstname"),contactDate.getFirstname());
    type(By.name("lastname"),contactDate.getLastname());
    type(By.name("address"),contactDate.getAddress());
    type(By.name("home"),contactDate.getHomePhone());
    type(By.name("email"),contactDate.getEmail());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void acceptDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@title='Edit']"));
  }


  public void submitContactModification() {
    click(By.name("update"));

  }
}
