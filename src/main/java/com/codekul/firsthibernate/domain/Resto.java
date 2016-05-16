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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_resto")
public class Resto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_resto",unique = true, nullable = false)
    private Long idResto;
    
    @Column(name = "name_resto",unique = false, nullable = false)
    private String restoName;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Foodies> listFoodies = new ArrayList<>();
    
    public void addFoodies(Foodies foodi) {
        
        listFoodies.add(foodi);
    }

    public Long getIdResto() {
        return idResto;
    }

    public void setIdResto(Long idResto) {
        this.idResto = idResto;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public List<Foodies> getListFoodies() {
        return listFoodies;
    }

    public void setListFoodies(List<Foodies> listFoodies) {
        this.listFoodies = listFoodies;
    }

    @Override
    public String toString() {
        return "Resto{" + "idResto=" + idResto + ", restoName=" + restoName + ", listFoodies=" + listFoodies + '}';
    }
    
    
}
