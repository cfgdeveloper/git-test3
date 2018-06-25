package com.jobs.application;

import java.util.ArrayList;
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

  public Employee createBossEmployee(String name, String address, String phone,
      double salaryPerMonth) throws Exception {
    Employee boss = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateBoss());
    repository.addMember(boss);
    return boss;
  }

  public Employee createEmployee(String name, String address, String phone, double salaryPerMonth)
      throws Exception {
    Employee emp = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateEmployee());
    repository.addMember(emp);
    return emp;
  }

  public Employee createManagerEmployee(String name, String address, String phone,
      double salaryPerMonth) throws Exception {
    Employee mgEmp = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateManager());
    repository.addMember(mgEmp);
    return mgEmp;

  }

  public Volunteer createVolunteer(String name, String address, String phone, String description)
      throws Exception {
    Volunteer vol = new Volunteer(name, address, phone, description);
    repository.addMember(vol);
    return vol;
  }

  public void payAllEmployeers() {
    List<AbsStaffMember> members = repository.getAllMembers();

    for (AbsStaffMember member : members) {
      member.pay();
    }
  }

  /*
   * public String getAllEmployees() { String strEmployees = "";
   * 
   * List<AbsStaffMember> members = repository.getAllMembers();
   * 
   * for (AbsStaffMember member : members) { strEmployees += member.toString(); }
   * 
   * return strEmployees; }
   */

  public List<AbsStaffMemberDTO> getAllEmployees() throws Exception {

    List<AbsStaffMember> members = repository.getAllMembers();
    List<AbsStaffMemberDTO> membersDTO = new ArrayList<AbsStaffMemberDTO>();

    for (AbsStaffMember member : members) {
      membersDTO.add(new AbsStaffMemberDTO(member));
    }

    return membersDTO;
  }

  /*
   * public void deleteEmployee(String employee) throws Exception { List<AbsStaffMember> members =
   * repository.getAllMembers();
   * 
   * AbsStaffMember m = null;
   * 
   * for (AbsStaffMember member : members) { if (member.getName().equals(employee)) { m = member; }
   * } if (m != null) { repository.deleteMember(m); } else {
   * System.out.println("ERROR: No se ha podido borrar: " + employee); } }
   */

  public void deleteEmployee(String employee) throws Exception {
    List<AbsStaffMember> members = repository.getAllMembers();

    for (AbsStaffMember member : members) {
      if (member.getName().equals(employee)) {
        repository.deleteMember(member);
      }
    }

  }
}
