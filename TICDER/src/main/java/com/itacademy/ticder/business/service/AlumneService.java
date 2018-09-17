/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itacademy.ticder.business.service;

import com.itacademy.ticder.data.entity.Alumne;
import com.itacademy.ticder.data.repository.AlumneRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumneService {
    
    private AlumneRepository alumneRepository;
    
    @Autowired
    public AlumneService(AlumneRepository alumneRep) {
        alumneRepository = alumneRep;
    }
    
    /*
        Recupera todos los alumnos de la BD
    */
    public List<Alumne> getAlumnes() {
        Iterable<Alumne> alumnes = this.alumneRepository.findAll();
        List<Alumne> alumnesList = new ArrayList<>();
        
        alumnes.forEach(a->{
            Alumne alumne = new Alumne();
            alumne.setId(a.getId());
            alumne.setNom(a.getNom());
            alumne.setCognom1(a.getCognom1());
            alumne.setCognom2(a.getCognom2());
            alumne.setDireccio(a.getDireccio());
            alumnesList.add(alumne);
        });
        Collections.shuffle(alumnesList);
        return alumnesList;
    }
    
    public void addAlumne(Alumne alumne) {
        this.alumneRepository.save(alumne);
    }
    
    public Alumne findById(long id) {
        return this.alumneRepository.findById(id).orElse(null);
    }

    public void deleteAlumne(long id) {
        this.alumneRepository.deleteById(id);
    }
    
    /*
        Recupera todos los alumnos de la BD y los agrupa,
        en parejas si el total de alumnos es par, o en
        grupos de tres si el total es impar.
    */
    public List<List> agrupaAlumnes() {
        List<Alumne> alumnesList = getAlumnes();
        Collections.shuffle(alumnesList);
        
        List<List> grups = new ArrayList<>();
        
        //TODO: controlar què passa si només hi ha un alumne
        //(tal i com esta fet ara, petaria).
        int numAlumnes = alumnesList.size();
        
        if (numAlumnes == 1) {
            
        }
        else if (numAlumnes % 2 == 0) {
            //num d'alumnes parell, fer grups de 2
            for (int i = 0; i < alumnesList.size(); i++) {
                List<Alumne> grup = new ArrayList<>();
                grup.add(alumnesList.get(i++));
                grup.add(alumnesList.get(i));
                grups.add(grup);
            }
        }
        else {
            //num d'alumnes imparell, fer grups de 2 i l'ultim de 3
            for (int i = 0; i < alumnesList.size()-1; i++) {
                List<Alumne> grup = new ArrayList<>();
                grup.add(alumnesList.get(i++));
                grup.add(alumnesList.get(i));
                grups.add(grup);
            }
            //afegim l'ultim, que ens queda desparellat
            grups.get(grups.size()-1).add(alumnesList.get(alumnesList.size()-1));
        }
        
        return grups;
    }
}
