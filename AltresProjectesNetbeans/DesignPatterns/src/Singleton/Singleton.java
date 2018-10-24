package Singleton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author formacio
 */
public class Singleton {
    private static Singleton unique;
    
    private Singleton(){}
    
    
    /*
    NOTA: este patrón no es thread safe. Para hacerlo, hay dos formas:
    1- Crear el objeto nada más arrancar el programa. Así:
        private static Singleton unique = new Singleton();
    
    2- Aplicar la palabra synchronized al método getInstance()
    
    */
    public static Singleton getInstance() {
        if (unique == null) {unique = new Singleton();}
        return unique;
    }
    
    public String getDescription() {
        return this.toString();
    }
}
