/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@DiscriminatorValue("tiger")
public class Tiger extends Animal{
    
    @Column(name = "stripe_count",unique = false, nullable = true)
    private Integer strpeCount;
    
    @Column(name = "from_india",unique = false, nullable = true, columnDefinition = "boolean default true")
    private Boolean fromInda = false;

    public Integer getStrpeCount() {
        return strpeCount;
    }

    public void setStrpeCount(Integer strpeCount) {
        this.strpeCount = strpeCount;
    }

    public Boolean getFromInda() {
        return fromInda;
    }

    public void setFromInda(Boolean fromInda) {
        this.fromInda = fromInda;
    }

    @Override
    public String toString() {
        return "Tiger{" + "strpeCount=" + strpeCount + ", fromInda=" + fromInda + '}';
    }
}
