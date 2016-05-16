/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_city", unique = true, nullable = false)
    private Long idCity;

    @Column(name = "city_name", unique = false, nullable = false)
    private String cityName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country")
    private Country country;

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" + "idCity=" + idCity + ", cityName=" + cityName + ", country=" + country + '}';
    }
    
       
}
