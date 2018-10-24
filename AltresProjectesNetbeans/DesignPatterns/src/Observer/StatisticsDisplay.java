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
public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    public StatisticsDisplay(Observable observable) {
            observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
            if (observable instanceof WeatherData) {
                    WeatherData weatherData = (WeatherData)observable;
                    float temp = weatherData.getTemperature();
                    tempSum += temp;
                    numReadings++;

                    if (temp > maxTemp) {
                            maxTemp = temp;
                    }

                    if (temp < minTemp) {
                            minTemp = temp;
                    }

                    display();
            }
    }

    public void display() {
            System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                    + "/" + maxTemp + "/" + minTemp);
    }
    
}
