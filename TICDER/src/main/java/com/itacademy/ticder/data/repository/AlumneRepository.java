/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itacademy.ticder.data.repository;

import com.itacademy.ticder.data.entity.Alumne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumneRepository extends CrudRepository<Alumne, Long> {

}
