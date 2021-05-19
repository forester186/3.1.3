package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("people", userService.getAllUser());
        return "admin/allUser";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap){
        modelMap.addAttribute("person", new User());
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "admin/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("person") User user, @RequestParam("roles") String[] roleList) {
        userService.saveUser(user, roleList);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/update")
    public String getUpdate(ModelMap modelMap, @PathVariable("id") Long id){
        modelMap.addAttribute("person", userService.gerUser(id));
        modelMap.addAttribute("roleList", userService.getAllRole());
        return "admin/update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") Long id, @RequestParam("roles") String[] roleList){
        userService.updateUser(id,user, roleList);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
