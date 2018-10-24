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
public class NoQuarterState implements State {

    private GumballMachine machine;
    
    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted.");
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter inserted yet.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Nothing happend, a quarter is needed.");
    }

    @Override
    public void dispense() {
        System.out.println("A quarter needs to be inserted first.");
    }
    
}
