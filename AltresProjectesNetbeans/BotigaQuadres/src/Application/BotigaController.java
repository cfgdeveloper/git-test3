/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Domain.Botiga;
import Domain.Quadre;
import Persistence.BotigaPersistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author formacio
 */
public class BotigaController {
    
    private Botiga botiga;
    private BotigaPersistence botigaPersistence;
    
    public BotigaController() throws Exception {
        createBotiga("Cuadros Capone S.A.", 10);
        botigaPersistence = new BotigaPersistence();
    }
    
    public void createBotiga(String name, int capacity) throws Exception{
        botiga = Botiga.retrieveBotiga(name, capacity);
    }
    
    public void createQuadre(String name, double price, String author) throws Exception{
        if (botigaPersistence.size() >= botiga.getCapacity()) {
            throw new Exception("FULL SHOP, NIGGA!!!");
        }
        Quadre quadre = new Quadre(name, price, author);
        botigaPersistence.add(quadre);
    }
    
    public void createQuadre(String name, double price) throws Exception{
        if (botigaPersistence.size() >= botiga.getCapacity()) {
            throw new Exception("FULL SHOP, NIGGA!!!");
        }
        Quadre quadre = new Quadre(name, price);
        botigaPersistence.add(quadre);
    }

    public void removeQuadre(String name) throws Exception{
        Quadre q = null;
        for (Quadre quadre : botigaPersistence.getAllItems()) {
            if(quadre.getName().equals(name)) {
                q = quadre;
            }
        }
        if (q == null) {throw new Exception("THIS QUADRE EXISTS, NIGGA!!!");}
        botigaPersistence.remove(q);
        
    }
    
    public List<QuadreDTO> getAllItems() {
        
        List<QuadreDTO> quadresDTO = new ArrayList<>();
        for (Quadre quadre : botigaPersistence.getAllItems()) {
            quadresDTO.add(new QuadreDTO(quadre));
        }
        return quadresDTO; 
    }
    
    public void obliterateBotiga() {
        botigaPersistence.obliterate();
    }
}
