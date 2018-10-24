/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.*;

/**
 *
 * @author formacio
 */
public class Botiga {
    private String name;
    private int capacity;
    private static Botiga botiga;
    
    
    private Botiga(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    
    public static Botiga retrieveBotiga(String name, int capacity) {
        if (botiga == null) {
            return new Botiga(name, capacity);
        }
        return botiga;
    }
    
    public int getCapacity() {
        return capacity;
    }
}
