package com.example.Medical.Records.v10.data.view.controller;

import com.example.Medical.Records.v10.data.entity.DepartmentType;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import com.example.Medical.Records.v10.data.view.model.physicians.CreatePhysicianAndGPViewModel;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

    @GetMapping("logout")
    public String logout(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

//    TODO fix register
    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String register(Model  model){
        System.out.println(model);
        model.addAttribute("departments", DepartmentType.values());

//        System.out.println("before");
        model.addAttribute("physician", new CreatePhysicianAndGPViewModel());
        return "register";
    }


    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }
}
