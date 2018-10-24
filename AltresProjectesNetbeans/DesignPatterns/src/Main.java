
import java.util.*;

import Strategy.*;
import Observer.*;
import Decorator.*;
import Singleton.*;
import State.*;
import Collection.*;
import Factory.*;

public class Main {
    
    public static void main(String[] args) {
        
        //    STRATEGY PATTERN
        /*
        MallardDuck mduck = new MallardDuck();
        RubberDuck rduck = new RubberDuck();
        
        mduck.display();
        mduck.performFly();
        mduck.performQuack();
        
        System.out.println();
        
        rduck.display();
        rduck.performFly();
        rduck.performQuack();
        rduck.setFlyBehaviour(new FlyRocketPower());
        rduck.performFly();
        */
        
        //    OBSERVER PATTERN
        /*
        WeatherData wdata = new WeatherData();
        
        ForecastDisplay forecastDisplay = new ForecastDisplay(wdata);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(wdata);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(wdata);
        
        wdata.setMeasurements(80, 85, 20.4f);
        wdata.setMeasurements(10, 20, 35.6f);
        wdata.setMeasurements(90, 60, 90.0f);
        */
        
        //    DECORATOR PATTERN
        /*Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        //Tambe es pot fer amb una sola linea
        //beverage2 = new Mocha(new Soy(beverage2));
        
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());*/
        
        //    SINGLETON PATTERN
        /*Singleton singletonObj = Singleton.getInstance();
        System.out.println(singletonObj);
        
        Singleton singletonObj2 = Singleton.getInstance();
        System.out.println(singletonObj2);
        
        Singleton singletonObj3 = Singleton.getInstance();
        System.out.println(singletonObj3);*/
        
        //    STATE PATTERN
        /*GumballMachine machine = new GumballMachine(2);
        
        machine.insertQuarter();
        machine.turnCrank();
        
        machine.insertQuarter();
        machine.turnCrank();
        
        machine.insertQuarter();
        machine.turnCrank();*/
        
        //    COLLECTION PATTERN
        /*PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinnerMenu = new DinerMenu();
        
        Iterator<String> pchmIterator = pancakeHouseMenu.createIterator();
        Iterator<String> dmIterator = dinnerMenu.createIterator();
        
        printMenu(pchmIterator);
        System.out.println("----------");
        printMenu(dmIterator);*/
        
        //    FACTORY PATTERN
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);
        
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.getName());
        System.out.println(pizza);
        
        pizza = store.orderPizza("clam");
        System.out.println("Ordered a " + pizza.getName());
        System.out.println(pizza);
    }
    
    
    public static void printMenu(Iterator it) {
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
}
