package com.example.demo.dao;


import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserDao {


    User save(User userDTO);

    List<User> getAllUser();

    List<Role> getAllRole();

    Role getRoleByName(String role);

    User gerUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserByName(String name);
}
