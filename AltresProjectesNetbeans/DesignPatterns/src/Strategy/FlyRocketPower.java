/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author formacio
 */
public class FlyRocketPower implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Flying with rocket power");
    }
    
}
