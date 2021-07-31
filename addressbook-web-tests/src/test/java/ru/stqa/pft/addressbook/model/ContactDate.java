package ru.stqa.pft.addressbook.model;

public class ContactDate {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String homePhone;
  private final String email;
  private final String group;

  public ContactDate(String firstname, String lastname, String address, String homePhone, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
