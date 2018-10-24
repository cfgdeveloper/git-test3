/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Domain.*;
import java.util.*;

/**
 *
 * @author formacio
 */
public class BotigaPersistence {
    List<Quadre> quadres = null;
    
    public BotigaPersistence() {
        quadres = new ArrayList<>();
    }
    
    public int size() {
        return quadres.size();
    }
    
    public void add(Quadre quadre) throws Exception{
        quadres.add(quadre);
    }
    
    public void remove(Quadre quadre) throws Exception{
        quadres.remove(quadre);
    }
    
    public List<Quadre> getAllItems() {
        return quadres;
    }
    
    public void obliterate() {
        quadres.clear();
    }
}
