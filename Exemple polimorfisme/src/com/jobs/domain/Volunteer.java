package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

  protected String description;

  public Volunteer(String name, String address, String phone, String description) throws Exception {
    super(name, address, phone);
    if (description == null)
      throw new Exception();

    this.description = description;
  }

  @Override
  public void pay() {
    // TODO

  }

  public String toString() {

    String data = "\n";
    data += "\nname: " + name;
    data += "\naddress: " + address;
    data += "\nphone: " + phone;
    data += "\nsalario: " + description;

    return data;
  }

}
