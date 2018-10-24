/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author formacio
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;
    
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", mocha cream";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
    
}
