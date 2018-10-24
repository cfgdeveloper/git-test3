/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author formacio
 */
public class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese pizza";
        dough = "Regular crust";
        sauce = "Marinara";
        
        toppings.add("Fresh mozzarella");
        toppings.add("Parmesan");
    }
    
}
