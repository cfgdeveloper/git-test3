
package View;

import Application.Controller;

/**
 *
 * @author formacio
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Controller cont = new Controller();
        
        cont.createRocket("32WESSDS");
        cont.addThruster("32WESSDS", 10);
        cont.addThruster("32WESSDS", 30);
        cont.addThruster("32WESSDS", 80);
        
        cont.createRocket("LDSFJA32");
        cont.addThruster("LDSFJA32", 30);
        cont.addThruster("LDSFJA32", 40);
        cont.addThruster("LDSFJA32", 50);
        cont.addThruster("LDSFJA32", 60);
        cont.addThruster("LDSFJA32", 30);
        cont.addThruster("LDSFJA32", 10);
        
        System.out.println(cont.getRocketData("32WESSDS"));
        System.out.println(cont.getRocketData("LDSFJA32"));
        
        //accelerate both rockets 3 times each
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        
        System.out.println(cont.getRocketData("32WESSDS"));
        System.out.println(cont.getRocketData("LDSFJA32"));
        
        //decelerate first rocket 5 times
        cont.speedDownRocket("32WESSDS");
        cont.speedDownRocket("32WESSDS");
        cont.speedDownRocket("32WESSDS");
        cont.speedDownRocket("32WESSDS");
        cont.speedDownRocket("32WESSDS");
        
        //accelerate second rocket 7 times
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        
        System.out.println(cont.getRocketData("32WESSDS"));
        System.out.println(cont.getRocketData("LDSFJA32"));
        
        //accelerate both rockets 15 times each
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        cont.speedUpRocket("32WESSDS");
        
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        cont.speedUpRocket("LDSFJA32");
        
        System.out.println(cont.getRocketData("32WESSDS"));
        System.out.println(cont.getRocketData("LDSFJA32"));
    }
}
