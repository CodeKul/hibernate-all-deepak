/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.repository;

import com.codekul.firsthibernate.domain.Car;
import com.codekul.firsthibernate.util.HbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Deepak Mandal
 */
public class CarRepositoryImpl implements CarRepository {

    @Override
    public Car findCarByName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Car obj) throws Exception {
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        session.save(obj);
        txn.commit();
        session.flush();
    }

    @Override
    public void update(Car obj) throws Exception {
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        session.saveOrUpdate(obj);
        txn.commit();
        session.flush();
    }

    @Override
    public void delete(Car obj) throws Exception {
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        session.delete(obj);
        txn.commit();
        session.flush();
    }

    @Override
    public Car query(Car t) throws Exception {
        
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        Car car = session.get(Car.class, t.getId());
        txn.commit();
        session.flush();
        
        return car;
   }
}