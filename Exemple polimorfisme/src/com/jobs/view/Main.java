package com.jobs.view;

import java.util.List;

import com.jobs.application.AbsStaffMemberDTO;
import com.jobs.application.JobsController;

public class Main {

  private static JobsController controller = new JobsController();

  public static void main(String[] args) throws Exception {

    controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
    controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
    controller.createEmployee("Laura Employee", "Dirección molona 3", "625266667", 45.0);
    controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", "Voluntario");
    controller.createManagerEmployee("Pedro Employee", "Dirección molona 6", "635246616", 80.0);

    controller.payAllEmployeers();

    // String allEmployees = controller.getAllEmployees();
    List<AbsStaffMemberDTO> allEmployees = controller.getAllEmployees();

    for (AbsStaffMemberDTO m : allEmployees) {
      System.out.print(m);
    }

    controller.deleteEmployee("Pedro Employee");
    controller.deleteEmployee("Laura Employee");
    controller.deleteEmployee("Pedro Employee");
    controller.deleteEmployee("Noexisto Employee");

    allEmployees = controller.getAllEmployees();

    /*
     * for (AbsStaffMemberDTO m : allEmployees) { System.out.print(m); }
     */

  }

}
