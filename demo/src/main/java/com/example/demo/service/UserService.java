package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {


    User save(User userDTO);

    List<User> getAllUser();

    User gerUser(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(User user);

    User getUserByName(String name);

    List<Role> getAllRole();

    Role getRoleByName(String role);
}
