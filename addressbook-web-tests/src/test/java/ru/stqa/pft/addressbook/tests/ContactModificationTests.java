package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Ivan").withLastname("Ivanov").
              withAddress("Moscow").withHomePhone("79099090099").withEmail("test1@mail.ru").withGroup("test1"),true);
    }
  }

  @Test
  public void testContactModification(){

    Set<ContactDate> before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate().withId(modifiedContact.getId())
            .withFirstname("Petr").withLastname("Petrov").withAddress("Omsk").withHomePhone("79088088080").withEmail("test2@mail.ru");
    app.contact().modify(contact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
