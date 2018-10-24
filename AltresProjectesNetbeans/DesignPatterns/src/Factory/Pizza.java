/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.*;

/**
 *
 * @author formacio
 */
abstract public class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();
    
    public String getName(){
        return name;
    }
    
    public void prepare() {
        System.out.println("Preparing " + name);
    }
    
    public void bake() {
        System.out.println("Baking " + name);
    }
    
    public void cut() {
        System.out.println("Cutting " + name);
    }
    
    public void box() {
        System.out.println("Boxing " + name);
    }
    
    public String toString() {
        String result = "";
        result += "Name: " + getName();
        result += "\nDough: " + dough;
        result += "\nSauce: " + sauce;
        result += "\nToppings: " + toppings;
        return result;
    }
}
