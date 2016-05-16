/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_mango")
@AttributeOverrides(value = 
        {@AttributeOverride(name = "idFruit",column = @Column(name = "id_mango")),
        @AttributeOverride(name = "season",column = @Column(name = "season_mango"))
        })
public class Mango extends Fruit{
    
    @Column(name = "mango_type",nullable = false,unique = false)
    private String mangoType;
    
    @Column(name = "mango_farm",nullable = false,unique = false)
    private String mangoFarms;

    public String getMangoType() {
        return mangoType;
    }

    public void setMangoType(String mangoType) {
        this.mangoType = mangoType;
    }

    public String getMangoFarms() {
        return mangoFarms;
    }

    public void setMangoFarms(String mangoFarms) {
        this.mangoFarms = mangoFarms;
    }

    @Override
    public String toString() {
        return "Mango{" + "mangoType=" + mangoType + ", mangoFarms=" + mangoFarms + '}';
    }
}
