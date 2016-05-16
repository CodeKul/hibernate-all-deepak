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
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_car")
public class Car {
    
    private Long id;
    private String carName;
    private Integer carNum;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "car_name", unique = false, nullable = true)
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Column(name = "car_num", unique = false, nullable = true)
    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", carName=" + carName + ", carNum=" + carNum + '}';
    }
}
