/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.Random;

/**
 *
 * @author formacio
 */
public class Warrior {
    String name;
    int maxHP;
    int currHP;
    public Warrior(String name, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.currHP = maxHP;
    }
    
    public void attack(Warrior w) {
        Random rand = new Random();
        int  damage = rand.nextInt(10) + 1;
        w.currHP -= damage;
        System.out.println(this.name + " attacks!");
        System.out.println(w.name + " got " + damage + " points of damage!\n");
    }
}
