/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_foodies")
public class Foodies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_foodies", unique = true, nullable = false)
    private Long idFoodies;

    @Column(name = "name_person", unique = false, nullable = false)
    private String namePerson;

    @Column(name = "dish", unique = false, nullable = false)
    private String dish;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tab_resto_foodies", 
            joinColumns = {
                @JoinColumn(name = "id_foodies", nullable = false, unique = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "id_resto",nullable = false,unique = false)
        }
    )
    private List<Resto> listResto = new ArrayList<>();
    
    public void addResto(Resto res){
        listResto.add(res);
    }

    public Long getIdFoodies() {
        return idFoodies;
    }

    public void setIdFoodies(Long idFoodies) {
        this.idFoodies = idFoodies;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public List<Resto> getListResto() {
        return listResto;
    }

    public void setListResto(List<Resto> listResto) {
        this.listResto = listResto;
    }

    @Override
    public String toString() {
        return "Foodies{" + "idFoodies=" + idFoodies + ", namePerson=" + namePerson + ", dish=" + dish + ", listResto=" + listResto + '}';
    }
    
    
}
