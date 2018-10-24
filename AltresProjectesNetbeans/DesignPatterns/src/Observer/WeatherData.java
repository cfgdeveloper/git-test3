/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.Observable;

/**
 *
 * @author formacio
 */
public class WeatherData extends Observable {

    private float humidity;
    private float temperature;
    private float pressure;
    
    public WeatherData() {
    
    }
    
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
    
    public void setMeasurements(float humidity, float temperature, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getPressure() {
        return this.pressure;
    }

    float getTemperature() {
        return this.temperature;
    }
    
    float getHumidity() {
        return this.humidity;
    }
}
