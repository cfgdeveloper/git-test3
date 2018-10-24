/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.*;
import java.util.Random;

/**
 *
 * @author formacio
 */
public class Main {

    
    static Warrior w1 = new Warrior("Conan el Petao", 50);
    static Warrior w2 = new Warrior("Elric el Moñas", 50);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Random rand1 = new Random();
        Random rand2 = new Random();
        Thread t1;
        Thread t2;
        List<Thread> threadList = new ArrayList<>();
        
        Runnable r1 = () -> {
            while (w1.currHP > 0 && w2.currHP > 0) {
                int time = rand1.nextInt(2500) + 1;
                try {
                    Thread.sleep(time);
                }
                catch(InterruptedException iex) {}
                w1.attack(w2);
            }
            threadList.get(1).interrupt();
            announceWinner();
        };
        
        Runnable r2 = () -> {
            while (w1.currHP > 0 && w2.currHP > 0) {
                int time = rand2.nextInt(2500) + 1;
                try {
                    Thread.sleep(time);
                }
                catch(InterruptedException iex) {}
                
                w2.attack(w1);
            }
            threadList.get(0).interrupt();
            
        };
        
        t1 = new Thread(r1); t1.start();
        t2 = new Thread(r2); t2.start();
        threadList.add(t1);
        threadList.add(t2); 
    }
    
    public static void announceWinner() {
    
        if (w1.currHP <= 0) {
            System.out.println(">>>>>>>>>" + w2.name + " has won the battle!");
        }
        else {
            System.out.println(">>>>>>>>>" + w1.name + " has won the battle!");
        }
    
    }
    
}
