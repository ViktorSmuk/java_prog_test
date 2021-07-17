package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoContactPage();
    app.fillContactForm(new ContactDate("Viktor", "Ivanov", "Moscow", "79099090099", "test1@mail.ru"));
    app.submitContactCreation();
    app.returnToContactPage();
  }

}
