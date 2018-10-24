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
public class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam pizza";
        dough = "Regular crust";
        sauce = "Clam sauce";
        
        toppings.add("Fresh mozzarella");
        toppings.add("Clams");
        toppings.add("Nori algae");
    }
    
}
