/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.firsthibernate.util;

import com.codekul.firsthibernate.domain.Animal;
import com.codekul.firsthibernate.domain.Car;
import com.codekul.firsthibernate.domain.City;
import com.codekul.firsthibernate.domain.Country;
import com.codekul.firsthibernate.domain.Foodies;
import com.codekul.firsthibernate.domain.Fruit;
import com.codekul.firsthibernate.domain.Human;
import com.codekul.firsthibernate.domain.Mango;
import com.codekul.firsthibernate.domain.Resto;
import com.codekul.firsthibernate.domain.Shop;
import com.codekul.firsthibernate.domain.Teacher;
import com.codekul.firsthibernate.domain.Tiger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Deepak Mandal
 */
public class HbUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Car.class);
            configuration.addAnnotatedClass(Shop.class);
            configuration.addAnnotatedClass(Animal.class);
            configuration.addAnnotatedClass(Tiger.class);
            configuration.addAnnotatedClass(Fruit.class);
            configuration.addAnnotatedClass(Mango.class);
            configuration.addAnnotatedClass(Human.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Country.class);
            configuration.addAnnotatedClass(City.class);
            configuration.addAnnotatedClass(Foodies.class);
            configuration.addAnnotatedClass(Resto.class);

            configuration.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/deepakdb");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "admin");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());// this is ging to be changed
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getNowSession() {

        if (session == null) {
            session = getSessionFactory().openSession();
        } else {
            session = getSessionFactory().getCurrentSession();
        }
        return session;
    }
}
