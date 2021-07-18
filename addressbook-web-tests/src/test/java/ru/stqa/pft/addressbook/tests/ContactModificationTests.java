package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDate("Petr", "Petrov", "Omsk", "79088088080", "test2@mail.ru"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();

  }
}
