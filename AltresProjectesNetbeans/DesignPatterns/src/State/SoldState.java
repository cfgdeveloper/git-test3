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
public class SoldState implements State {

    private GumballMachine machine;
    
    public SoldState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("The machine is sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You have already turned the crank.");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
		if (machine.getCount() > 0) {
			machine.setState(machine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			machine.setState(machine.getSoldOutState());
		}
    }
    
}
