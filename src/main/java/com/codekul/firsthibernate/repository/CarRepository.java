/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.repository;

import com.codekul.firsthibernate.domain.Car;

/**
 *
 * @author Deepak Mandal
 */
public interface CarRepository extends BaseRepository<Car>{
    
    Car findCarByName(String name) throws Exception;
}
