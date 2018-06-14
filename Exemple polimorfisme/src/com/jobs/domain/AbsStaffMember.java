package com.jobs.domain;

public abstract class AbsStaffMember {

  protected int id;
  protected String name;
  protected String address;
  protected String phone;
  protected double totalPaid = 0;

  private static int COUNTER_MEMBERS = 1;

  public AbsStaffMember(String name, String address, String phone) throws Exception {
    if (name.equals(""))
      throw new Exception();
    if (address.equals(""))
      throw new Exception();
    if (phone.equals(""))
      throw new Exception();

    this.name = name;
    this.address = address;
    this.phone = phone;
    id = getCOUNTER_MEMBERS();
    setCOUNTER_MEMBERS(getCOUNTER_MEMBERS() + 1);
  }

  public abstract void pay();

  public static int getCOUNTER_MEMBERS() {
    return COUNTER_MEMBERS;
  }

  public static void setCOUNTER_MEMBERS(int cOUNTER_MEMBERS) {
    COUNTER_MEMBERS = cOUNTER_MEMBERS;
  }
}
