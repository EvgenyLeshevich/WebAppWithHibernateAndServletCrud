package com.evgeniy.web.crud.hibernate.services;

import com.evgeniy.web.crud.hibernate.dao.UserDao;
import com.evgeniy.web.crud.hibernate.entity.User;

import java.util.List;

public class UserService implements Services<User, Long>{
    private UserDao userDao = new UserDao();

    public UserService() {
    }

    public void add(User entity){
        userDao.add(entity);
    }

    public void update(User entity){
        userDao.update(entity);
    }

    public User searchById(Long id){
        User user = userDao.searchById(id);
        return user;
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    public List<User> searchAll(){
        List<User> users = userDao.searchAll();
        return users;
    }

    public void deleteAll(){
        userDao.deleteAll();
    }

    public List<User> searchByFirstName(String firstName,String lastName){
        List<User> users = userDao.searchByFirstName(firstName,lastName);
        return users;
    }

    public void deleteByFirstName(String firstName) {
        userDao.deleteByFirstName(firstName);
    }
}
