package com.example.springbootdenispronin.controller;

import com.example.springbootdenispronin.model.Role;
import com.example.springbootdenispronin.model.User;
import com.example.springbootdenispronin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model, Principal principal) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", new User());
        model.addAttribute("userToAdd", new User());
        model.addAttribute("roleAdminToAdd", new Role("ROLE_ADMIN"));
        model.addAttribute("roleUserToAdd", new Role("ROLE_USER"));
        model.addAttribute("admin", userService.showByName(principal.getName()));
        return "admin";
    }

    @PostMapping
    public String create(@ModelAttribute("userToAdd") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Ошибка в запросе");
            return "redirect:/admin";
        }

        userService.create(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PatchMapping
    public String update(@ModelAttribute("userToUpdate") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Ошибка в запросе");
            return "redirect:/admin";
        }

        userService.update(user);
        return "redirect:/admin";
    }

}
