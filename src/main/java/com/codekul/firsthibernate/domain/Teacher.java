/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Deepak Mandal
 */
@Entity
@Table(name = "tab_teacher")
@PrimaryKeyJoinColumn(name = "id_human")
public class Teacher extends Human{
    
    @Column(name = "school",unique = false, nullable = false)
    private String school;
    
    @Column(name = "subject",unique = false, nullable = false)
    private String subject;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" + "school=" + school + ", subject=" + subject + '}';
    }
}
