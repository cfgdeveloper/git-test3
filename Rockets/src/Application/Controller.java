
package Application;

import Domain.Rocket;
import java.util.*;

/**
 *
 * @author formacio
 */
public class Controller {
    
    private List<Rocket> rockets = null;
    
    public Controller() {
        rockets = new ArrayList<>();
    }
    
    public void createRocket(String code) throws Exception {
        rockets.add(new Rocket(code));
    }
    
    public void addThruster(String code, int maxSpeed) throws Exception {
        for (Rocket r : rockets) {
            if (r.getCode().equals(code)) {
                r.addThruster(maxSpeed);
            }
        }
    }
    
    
    public void speedUpRocket(String code) {
        for (Rocket r : rockets) {
            if (r.getCode().equals(code)) {
                r.speedUpAll();
            }
        }
    }
    
    public void speedDownRocket(String code) {
        for (Rocket r : rockets) {
            if (r.getCode().equals(code)) {
                r.speedDownAll();
            }
        }
    }
    
    
    
    
    
    public String getRocketData(String code) throws Exception {
        for (Rocket r : rockets) {
            if (r.getCode().equals(code)) {
                return r.toString();
            }
        }
        throw new Exception("Rocket not found");
    }
}
