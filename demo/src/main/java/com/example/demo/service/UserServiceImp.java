package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);

    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public User gerUser(Long id) {
        return userDao.gerUser(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        userDao.deleteUser(id);
        return false;
    }

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

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public List<Role> getAllRole() {
        return userDao.getAllRole();
    }
}
