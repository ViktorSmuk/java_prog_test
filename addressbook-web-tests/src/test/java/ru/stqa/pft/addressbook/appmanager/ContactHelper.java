package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactHelper {
  private FirefoxDriver wd;

  public ContactHelper (FirefoxDriver wd){

    this.wd = wd;
  }

  public void returnToContactPage() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void submitContactCreation() { wd.findElement(By.linkText("home page")).click();
  }

    public void fillContactForm(ContactDate contactDate) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactDate.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactDate.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactDate.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactDate.getHomePhone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactDate.getEmail());
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }
}
