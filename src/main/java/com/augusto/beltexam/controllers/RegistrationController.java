package com.augusto.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.augusto.beltexam.models.Waitstaff;
import com.augusto.beltexam.services.WaitstaffService;
import com.augusto.beltexam.validator.WaitstaffValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class RegistrationController {
    
    private final WaitstaffService waitstaffService;
    private final WaitstaffValidator waitstaffValidator;    

    String errorLog = "";

    @GetMapping("")
    public String registerAndLogin(@ModelAttribute ("waitstaff") Waitstaff waitstaff,Model model) {
        model.addAttribute("errorLog",errorLog);
        return "registration";
    }

    @PostMapping("")
    public String registerUser(@Valid @ModelAttribute ("waitstaff") Waitstaff waitstaff, BindingResult result, HttpSession session,Model model) {

        waitstaffValidator.validate(waitstaff, result);

        if (waitstaffService.findByEmail(waitstaff.getEmail()) != null) {
            String errorEmail= "Este email ya esta registrado.";
            model.addAttribute("errorEmail", errorEmail);
            return "registration";
        }
        if (result.hasErrors()) {
            return "registration";
        } else {
            waitstaffService.registerWaitstaff(waitstaff);
            Long waitstaffId = waitstaff.getId();
            session.setAttribute("waitstaffId", waitstaffId);
        }
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String loginWaitstaff(
        @RequestParam("email") String email, 
        @RequestParam("password") String password, 
        HttpSession session) {
        if (waitstaffService.authenticateWaitstaff(email, password)) {

            Waitstaff waitstaff = waitstaffService.findByEmail(email);
            Long waitstaffId = waitstaff.getId();
            session.setAttribute("waitstaffId", waitstaffId);
            return "redirect:/home";
            
        } else {
            errorLog="El email o la contraseña no coinciden.";
        }
        return "redirect:/";
    }


}
