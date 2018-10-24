/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author formacio
 */
public class Quadre {
    private String name;
    private String author;
    private double price;
    private Date admissionDate;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }
    
    public Quadre(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.admissionDate = new Date();
    }
    
    public Quadre(String name, double price) {
        this.name = name;
        this.price = price;
        this.author = "unknown";
        this.admissionDate = new Date();
    }
    
}
