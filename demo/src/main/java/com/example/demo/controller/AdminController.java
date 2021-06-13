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

    @GetMapping("/new")
    public String newUser(ModelMap modelMap){
        modelMap.addAttribute("person", new User());
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "admin/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("person") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/update")
    public String getUpdate(ModelMap modelMap, @PathVariable("id") Long id){
        modelMap.addAttribute("person", userService.gerUser(id));
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "admin/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
