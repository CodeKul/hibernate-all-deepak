/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
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
@Table(name = "tab_animal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "anitig",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("animal")
public abstract class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_animal",unique = true,nullable = false)
    private Long idAnimal;
    
    @Column(name = "animal_name",unique = false,nullable = false)
    private String animalName;
    
    @Column(name = "animal_country",unique = false,nullable = false)
    private String coutry;

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", animalName=" + animalName + ", coutry=" + coutry + '}';
    }
}
