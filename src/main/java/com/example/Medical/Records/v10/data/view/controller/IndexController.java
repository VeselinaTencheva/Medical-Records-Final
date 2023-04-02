package com.example.Medical.Records.v10.data.view.controller;

import com.example.Medical.Records.v10.data.entity.DepartmentType;
import com.example.Medical.Records.v10.data.entity.physicians.Physician;
import com.example.Medical.Records.v10.data.view.model.physicians.CreatePhysicianAndGPViewModel;
import com.example.Medical.Records.v10.dto.physician.CreatePhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.PhysicianDTO;
import com.example.Medical.Records.v10.dto.physician.UpdatePhysicianDTO;
import com.example.Medical.Records.v10.service.physician.PhysicianService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private ModelMapper modelMapper;
    private PhysicianService physicianService;

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

    @PostMapping("/register")
    public String createPhysician(Model model, @Valid @ModelAttribute("physician") CreatePhysicianAndGPViewModel physician, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", DepartmentType.values());
            return "/physicians/create";
        }
        CreatePhysicianDTO createPhysicianDTO = modelMapper.map(physician, CreatePhysicianDTO.class);
        physicianService.create(createPhysicianDTO);
        return "redirect:/physicians";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }
}
