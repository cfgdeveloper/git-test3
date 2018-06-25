package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class AbsStaffMemberDTO {

  private String name;
  private String address;
  private String phone;
  private double totalPaid;

  public AbsStaffMemberDTO(AbsStaffMember m) throws Exception {
    if (m == null) {
      throw new Exception();
    }
    this.name = m.getName();
    this.address = m.getAddress();
    this.phone = m.getPhone();
    this.totalPaid = m.getTotalPaid();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public double getTotalPaid() {
    return totalPaid;
  }

  public void setTotalPaid(double totalPaid) {
    this.totalPaid = totalPaid;
  }

  public String toString() {
    return name + " / " + address + " / " + phone + " / " + totalPaid + "\n";

  }
}
