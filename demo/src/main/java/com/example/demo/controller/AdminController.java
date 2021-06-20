package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(ModelMap modelMap, Principal principal){
        User user = userService.getUserByName(principal.getName());
        modelMap.addAttribute("admin", user);
        modelMap.addAttribute("people", userService.getAllUser());
        modelMap.addAttribute("person", new User());
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "admin/allUser";
    }
}
