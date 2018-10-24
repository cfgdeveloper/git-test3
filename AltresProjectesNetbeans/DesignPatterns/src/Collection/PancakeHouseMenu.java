/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.*;

/**
 *
 * @author formacio
 */
public class PancakeHouseMenu implements Menu {

    List<String> menuItems = new ArrayList<String>();
    
    public PancakeHouseMenu() {
        menuItems.add("Pancake breakfast");
        menuItems.add("Regular pancake");
        menuItems.add("Blueberry pancakes");
        menuItems.add("Waffles");
    }
    
    
    private void addItem(String item) {
        menuItems.add(item);
    }
    
    
    public List<String> getMenuItems() {
        return menuItems;
    }
    
    
    public Iterator<String> createIterator() {
        return menuItems.iterator();
    }
    
    
    public String toString() {
        return "Pancake House Menu";
    }
    
}
