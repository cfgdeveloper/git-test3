/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author formacio
 */
public class HasQuarterState implements State {

    private GumballMachine machine;
    
    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Cannot insert another quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned.");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Obtained a gumball.");
    }
    
}
