package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactDate().withFirstname("Ivan").withLastname("Ivanov").
              withAddress("Moscow").withHomePhone("79099090099").withEmail("test1@mail.ru").withGroup("test1"),true);
    }
  }

  @Test
  public void testContactDeletion () {
    List<ContactDate> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
