/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author formacio
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;  
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
            observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
            if (observable instanceof WeatherData) {
                    WeatherData weatherData = (WeatherData)observable;
                    lastPressure = currentPressure;
                    currentPressure = weatherData.getPressure();
                    display();
            }
    }

    public void display() {
            System.out.print("Forecast: ");
            if (currentPressure > lastPressure) {
                    System.out.println("Improving weather on the way!");
            } else if (currentPressure == lastPressure) {
                    System.out.println("More of the same");
            } else if (currentPressure < lastPressure) {
                    System.out.println("Watch out for cooler, rainy weather");
            }
    }
    
}
