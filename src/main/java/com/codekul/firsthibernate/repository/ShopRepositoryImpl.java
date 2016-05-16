/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.repository;

import com.codekul.firsthibernate.domain.Shop;
import com.codekul.firsthibernate.util.HbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Deepak Mandal
 */
public class ShopRepositoryImpl implements ShopRepository{

    @Override
    public void insert(Shop obj) throws Exception {
        
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        session.save(obj);
        txn.commit();
        session.flush();
    }

    @Override
    public void update(Shop t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Shop t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shop query(Shop t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
