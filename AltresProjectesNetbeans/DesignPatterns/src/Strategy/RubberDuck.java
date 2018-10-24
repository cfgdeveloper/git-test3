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
public class RubberDuck extends Duck {

    
    public RubberDuck() {
        quackBehaviour = new Squeak();
        flyBehaviour = new FlyNoWay();
    }
    
    @Override
    public void display() {
        System.out.println("RUBBER_DUCK.JPG");
    }
    
}
