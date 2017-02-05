package com.myservice.data.manager;

import com.myservice.data.HibernateSessionFactory;
import com.myservice.data.pojo.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Zloy on 05.02.2017.
 */
public class UserManager {

    private static final Logger LOGGER = Logger.getLogger(UserManager.class.getName());

    private User user;

    public UserManager(User user){
        this.user = user;
    }

    public void delete(){
        EntityManager manager = HibernateSessionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.detach(user);
            manager.getTransaction().commit();

        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally {
            manager.close();
        }
    }

    public void update(){
        EntityManager manager = HibernateSessionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(user);
            manager.getTransaction().commit();

        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally {
            manager.close();
        }
    }

    public void save(){
        EntityManager manager = HibernateSessionFactory.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();

        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally {
            manager.close();
        }
    }

    public User getUser(){
        return user;
    }

    public static UserManager getUserByLogin(String login){
        EntityManager manager = HibernateSessionFactory.getEntityManager();

        List<User> users = manager.createQuery(
                "SELECT c FROM User c WHERE c.login LIKE :login")
                .setParameter("login", login)
                .setMaxResults(1)
                .getResultList();

        return users.isEmpty() ? null : new UserManager(users.get(0));
    }


}
