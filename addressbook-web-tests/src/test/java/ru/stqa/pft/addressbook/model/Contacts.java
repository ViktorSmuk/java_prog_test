package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactDate> {

  private final HashSet<ContactDate> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactDate>(contacts.delegate);
  }




  @Override



  protected Set<ContactDate> delegate() {
    return delegate;
  }
}
