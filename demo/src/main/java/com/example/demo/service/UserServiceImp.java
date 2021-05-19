package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void saveUser(User user, String[] roleList) {
        userDao.saveUser(user, roleList);
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
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(Long id, User user, String[] roleList) {
        userDao.updateUser(id,user, roleList);
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
