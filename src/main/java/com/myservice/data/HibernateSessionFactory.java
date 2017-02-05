package com.myservice.data;

import com.myservice.data.pojo.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

/**
 * Created by Zloy on 04.02.2017.
 */
public class HibernateSessionFactory {

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static EntityManager entityManager = null;


    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(Item.class);
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());

        return sessionFactory;
    }

    public static EntityManager getEntityManager(){
        return entityManager == null ? entityManager = sessionFactory.createEntityManager() : entityManager;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}