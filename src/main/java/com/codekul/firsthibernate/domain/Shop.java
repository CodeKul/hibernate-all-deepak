/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_shop")
public class Shop {
    
    private Long idShop;
    private String shopName;
    private String owner;
    
    private Collection<String> addresses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_shop",nullable = false,unique = true)
    public Long getIdShop() {
        return idShop;
    }

    public void setIdShop(Long idShop) {
        this.idShop = idShop;
    }

    @Column(name ="shop_name",nullable = false,unique = false)
    public String getShopName() {
        
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column(name ="shop_owner",nullable = true,unique = false)
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    @ElementCollection
    @CollectionTable(name = "shop_addreses", joinColumns = @JoinColumn(name = "id_shop"))
    @Column(name = "address",nullable = false,unique = false)
    public Collection<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
    
    public void addAddreses(String address){
        addresses.add(address); 
    }

    @Override
    public String toString() {
        return "Shop{" + "idShop=" + idShop + ", shopName=" + shopName + ", owner=" + owner + ", addresses=" + addresses + '}';
    }
}
