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
public abstract class Beverage {
    
    String description = "Generic abstract beverage";
    
    public Beverage() {}
    
    public String getDescription() {return description;}
    
    public abstract double cost();
    
}
