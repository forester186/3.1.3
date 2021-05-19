package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user,String[] roleList);

    List<User> getAllUser();

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user, String[] roleList);

    User getUserByName(String name);

    List<Role> getAllRole();

    Role getRoleByName(String role);
}
