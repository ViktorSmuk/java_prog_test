package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Ivan").withLastname("Ivanov").
              withAddress("Moscow").withHomePhone("79099090099").withEmail("test1@mail.ru").withGroup("test1"),true);
    }
  }

  @Test
  public void testContactDeletion () {
    Set<ContactDate> before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
