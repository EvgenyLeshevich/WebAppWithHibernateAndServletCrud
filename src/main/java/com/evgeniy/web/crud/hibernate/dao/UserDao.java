package com.evgeniy.web.crud.hibernate.dao;

import com.evgeniy.web.crud.hibernate.entity.User;
import com.evgeniy.web.crud.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao implements DAO<User, Long> {

    @Override
    public void add(User entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User searchById(Long id) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.get(User.class, id);
            if(user!=null){
                return user;
            } else {
                System.out.println("Employee doesn't exist with provided Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           User user = searchById(id);
           if(user!=null){
               session.beginTransaction();
               session.delete(user);
               session.getTransaction().commit();
           } else{
               System.out.println("Employee doesn't exist with provided Id..");
           }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User ", User.class).list();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }
    }

    public List<User> searchByFirstName(String firstName, String lastName){
        List<User> users = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User U where U.firstName = :firstName and U.lastName = :lastName";
            Query query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            users = query.getResultList();
            if(users!=null && !users.isEmpty()){
                return users;
            } else{
                System.err.println("There are no users with the first name " + firstName
                        + " and the last name " + lastName);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByFirstName(String firstName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "delete from User U where U.firstName = :firstName";
            Query query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
