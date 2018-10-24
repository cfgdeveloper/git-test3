/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;

/**
 *
 * @author formacio
 */
public class DinerMenu implements Menu {
    
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    String[] menuItems;
    
    public DinerMenu() {
        
        menuItems = new String[MAX_ITEMS];
        
        addItem("Vegetarian BTL");
        addItem("BTL");
        addItem("Soup of the day");
        addItem("Hot dog");
        addItem("Veggies and rice");
        addItem("Pasta");
        
    }
    
    
    
    public String[] getMenuItems() {
        return menuItems;
    }
    
    
    
    private void addItem(String item) {
        
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Menu full, cannot add more items");
        }
        else {
            menuItems[numberOfItems] = item;
            numberOfItems++;
        }
    }
    
    public Iterator<String> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
    
    
    public String toString() {
        return "Dinner Menu";
    }
}
