package com.example.demo.controller;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return userService.getAllRole();
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user")
    public User getUser(Principal principal) {
        return userService.getUserByName(principal.getName());
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> list = userService.getAllUser();
        return list;
    }

    @PutMapping("/users")
    public void editUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }










}
