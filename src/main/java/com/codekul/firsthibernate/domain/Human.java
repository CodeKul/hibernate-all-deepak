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
@Table(name = "tab_human")
@Inheritance(strategy = InheritanceType.JOINED)
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_human",unique = true, nullable = false)
    private Long idHuman;
    
    @Column(name = "name_human",unique = false, nullable = false)
    private String nameHuman;
    
    @Column(name = "age",unique = false, nullable = true)
    private Integer age;

    public Long getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(Long idHuman) {
        this.idHuman = idHuman;
    }

    public String getNameHuman() {
        return nameHuman;
    }

    public void setNameHuman(String nameHuman) {
        this.nameHuman = nameHuman;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" + "idHuman=" + idHuman + ", nameHuman=" + nameHuman + ", age=" + age + '}';
    }
}
