/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name ="tab_fruit")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Fruit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fruit",unique = true,nullable = false)
    private Long idFruit;
    
    @Column(name = "season", unique = false, nullable = true)
    private String season;

    public Long getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(Long idFruit) {
        this.idFruit = idFruit;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
