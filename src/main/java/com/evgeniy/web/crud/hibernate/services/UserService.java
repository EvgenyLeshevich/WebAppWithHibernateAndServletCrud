package com.evgeniy.web.crud.hibernate.services;

import com.evgeniy.web.crud.hibernate.dao.UserDao;
import com.evgeniy.web.crud.hibernate.entity.User;

import java.util.List;

public class UserService {
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

    public void delete(Long id){
        userDao.delete(id);
    }

    public List<User> findAll(){
        List<User> users = userDao.findAll();
        return users;
    }

    public void deleteAll(){
        userDao.deleteAll();
    }
}
