package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

  private EmployeeRepository repository;

  public JobsController() {
    repository = new EmployeeRepository();
  }

  public void createBossEmployee(String name, String address, String phone, double salaryPerMonth)
      throws Exception {
    Employee boss = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateBoss());
    repository.addMember(boss);
  }

  public void createEmployee(String name, String address, String phone, double salaryPerMonth)
      throws Exception {
    Employee boss = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateEmployee());
    repository.addMember(boss);
  }

  public void createManagerEmployee(String name, String address, String phone,
      double salaryPerMonth) throws Exception {

    // TODO Auto-generated method stub
    Employee boss = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateManager());
    repository.addMember(boss);

  }

  public void createVolunteer(String name, String address, String phone, String description)
      throws Exception {
    // TODO Auto-generated method stub
    Volunteer boss = new Volunteer(name, address, phone, description);
    repository.addMember(boss);
  }

  public void payAllEmployeers() {
    // TODO Auto-generated method stub
    List<AbsStaffMember> members = repository.getAllMembers();

    for (AbsStaffMember member : members) {
      member.pay();
    }
  }

  public String getAllEmployees() {
    // TODO Auto-generated method stub
    String strEmployees = "";

    List<AbsStaffMember> members = repository.getAllMembers();

    for (AbsStaffMember member : members) {
      strEmployees += member.toString();
    }

    return strEmployees;
  }

}
