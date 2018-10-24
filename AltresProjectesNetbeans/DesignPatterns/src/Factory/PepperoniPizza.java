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
public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        name = "Pepperoni pizza";
        dough = "Regular crust";
        sauce = "BBQ sauce";
        
        toppings.add("Fresh mozzarella");
        toppings.add("ham");
        toppings.add("Pepperoni");
    }
    
}
