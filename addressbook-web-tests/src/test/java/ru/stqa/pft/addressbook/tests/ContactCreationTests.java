package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Set;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactDate> before = app.contact().all();
    ContactDate contact = new ContactDate().withFirstname("Ivan").withLastname("Ivanov").
            withAddress("Moscow").withHomePhone("79099090099").withEmail("test1@mail.ru").withGroup("test1");
    app.contact().create(contact,true);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
