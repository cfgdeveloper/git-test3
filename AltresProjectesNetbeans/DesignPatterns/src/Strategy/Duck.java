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
public abstract class Duck {
    
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    
    public Duck() {   
    }
    
    public void setFlyBehaviour(FlyBehaviour fb) {
        flyBehaviour = fb;
    }
    
    public void setQuackBehaviour(QuackBehaviour qb) {
        quackBehaviour = qb;
    }
    
    public void performFly() {
        flyBehaviour.fly();
    }
    
    public void performQuack() {
        quackBehaviour.quack();
    }
    
    abstract void display();
    
    public void swim() {
        System.out.println("All ducks can swim");
    }
}
