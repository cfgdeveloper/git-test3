/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itacademy.ticder.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALUMNE")
public class Alumne {
    @Id
    @Column(name="ALUMNE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="NOM")
    private String nom;
    @Column(name="COGNOM1")
    private String cognom1;
    @Column(name="COGNOM2")
    private String cognom2;
    @Column(name="DIRECCIO")
    private String direccio;

    
    public Alumne() {
    
    }
    
    public Alumne(long id, String nom, String cognom1, String cognom2, String direccio) {
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.direccio = direccio;
    }
    
    
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the cognom1
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * @param cognom1 the cognom1 to set
     */
    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    /**
     * @return the cognom2
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * @param cognom2 the cognom2 to set
     */
    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    /**
     * @return the direccio
     */
    public String getDireccio() {
        return direccio;
    }

    /**
     * @param direccio the direccio to set
     */
    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }
}
