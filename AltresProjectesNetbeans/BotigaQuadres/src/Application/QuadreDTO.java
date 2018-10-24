/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Domain.Quadre;
import java.util.Date;

/**
 *
 * @author formacio
 */
public class QuadreDTO {
    private String name;
    private String author;
    private double price;
    private Date admissionDate;
    
    public QuadreDTO(Quadre quadre) {
        this.name = quadre.getName();
        this.author = quadre.getAuthor();
        this.price = quadre.getPrice();
        this.admissionDate = quadre.getAdmissionDate();
                
    }

    @Override
    public String toString() {
        return "QuadreDTO{" + "name=" + name + ", author=" + author + ", price=" + price + ", admissionDate=" + admissionDate + "}\n";
    }
    
    
}
