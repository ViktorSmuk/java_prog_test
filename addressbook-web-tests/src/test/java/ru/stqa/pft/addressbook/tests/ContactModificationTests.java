package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Viktor", "Ivanov", "Moscow", "79099090099", "test1@mail.ru","test1"),true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDate("Petr", "Petrov", "Omsk", "79088088080", "test2@mail.ru",null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();

  }
}
