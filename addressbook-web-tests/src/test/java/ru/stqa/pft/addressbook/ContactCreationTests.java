package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    fillContactForm(new ContactDate("Viktor", "Ivanov", "Moscow", "79099090099", "test1@mail.ru"));
    submitContactCreation();
    returnToContactPage();
  }

}
