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
public interface State {
    
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
