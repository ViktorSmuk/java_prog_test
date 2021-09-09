package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    List<ContactDate> before = app.contact().list();
    ContactDate contact = new ContactDate().withFirstname("Ivan").withLastname("Ivanov").
            withAddress("Moscow").withHomePhone("79099090099").withEmail("test1@mail.ru").withGroup("test1");
    app.contact().create(contact,true);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactDate> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
