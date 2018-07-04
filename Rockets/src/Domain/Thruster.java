
package Domain;

/**
 *
 * @author formacio
 */
public class Thruster {
    
    public static int inc = 10;
    
    private int currentSpeed = 0;
    private int maxSpeed;
    
    
    
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    
    
    
    
    
    public Thruster(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public void speedUp() {
        this.currentSpeed += inc; 
        if (currentSpeed > maxSpeed) {
         this.currentSpeed = maxSpeed; 
        }
    }
    
    public void speedDown() {
        this.currentSpeed -= inc;
        if (currentSpeed < 0) {
            this.currentSpeed = 0; 
        }
    }
}
