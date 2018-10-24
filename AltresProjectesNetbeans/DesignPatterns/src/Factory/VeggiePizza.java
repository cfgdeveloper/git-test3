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
public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "Veggie pizza";
        dough = "Crust";
        sauce = "Thyme sauce";
        
        toppings.add("Soia cheese");
        toppings.add("Spinach");
        toppings.add("Mushrooms");
        toppings.add("Olives");
        toppings.add("Tomato");
    }
    
}
