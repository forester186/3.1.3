package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    @Override
    public User gerUser(Long id) {
        return userDao.gerUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public Role getRoleByName(String role) {
        return userDao.getRoleByName(role);
    }

    @Override
    public List<Role> getAllRole() {
        return userDao.getAllRole();
    }
}
