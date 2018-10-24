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
public class GumballMachine {
    
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    
    State state = noQuarterState;
    int count = 0;
    
    public GumballMachine(int numberGumBalls) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        
        this.count = numberGumBalls;
        if (count > 0) {
            state = noQuarterState;
        }
    }
    
    public void insertQuarter() {
        state.insertQuarter();
    }
    
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    
    void releaseBall() {
        System.out.println("A gumball is released");
        if (count != 0) {
            count -= 1;
        }
    }
    
    void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }
    
    
    
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }
    
    public int getCount() {
        return count;
    }
    
    
    public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}