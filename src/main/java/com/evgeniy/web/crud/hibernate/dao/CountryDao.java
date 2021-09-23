package com.evgeniy.web.crud.hibernate.dao;

import com.evgeniy.web.crud.hibernate.entity.Country;
import com.evgeniy.web.crud.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CountryDao implements DAO<Country, Long>{
    @Override
    public void add(Country entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country searchById(Long id) {
        Country country = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            country = session.get(Country.class, id);
            if(country!=null){
                return country;
            } else {
                System.out.println("Country doesn't exist with provided Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Country country = searchById(id);
            if(country!=null){
                session.beginTransaction();
                session.delete(country);
                session.getTransaction().commit();
            } else{
                System.out.println("Country doesn't exist with provided Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> searchAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Country ", Country.class).getResultList();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Country ").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
