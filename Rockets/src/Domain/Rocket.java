
package Domain;

import java.util.*;

/**
 *
 * @author formacio
 */
public class Rocket {

    private String code;
    private int rocketSpeed;
    private List<Thruster> thrusters = null;
    
    
    
    
    public String getCode() {
        return code;
    }
    
    
    
    
    public Rocket(String code) throws Exception {
        this.code = code;
        thrusters = new ArrayList<>();
    }
    
    public void addThruster(int maxSpeed) throws Exception {
        thrusters.add(new Thruster(maxSpeed));
    }
    
    
    public void speedUpAll() {
        for (Thruster t : thrusters) {
            t.speedUp();
        }
        updateRocketSpeed();
    }
    
    public void speedUp(int numThruster) {
        thrusters.get(numThruster).speedUp();
        updateRocketSpeed();
    }
    
    public void speedDownAll() {
        for (Thruster t : thrusters) {
            t.speedDown();
        }
        updateRocketSpeed();
    }
    
    public void speedDown(int numThruster) {
        thrusters.get(numThruster).speedDown();
        updateRocketSpeed();
    }
    
    private void updateRocketSpeed() {
        rocketSpeed = 0;
        for (Thruster t : thrusters) {
            rocketSpeed += t.getCurrentSpeed();
        }
    }
    
    public String toString() {
        String result =  "CODE: " + this.code + ". SPEED: " + this.getRocketSpeed() + "\n";
        for (Thruster t : thrusters) {
            result += "C:" + t.getCurrentSpeed() + " - M:" + t.getMaxSpeed() + "\t";
        }
        
        return result + "\n";
    }

    private int getRocketSpeed() {
        return rocketSpeed;
    }
}
