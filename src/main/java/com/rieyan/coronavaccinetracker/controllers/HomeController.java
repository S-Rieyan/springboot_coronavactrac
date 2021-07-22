package com.rieyan.coronavaccinetracker.controllers;


import com.rieyan.coronavaccinetracker.services.coronavaccineservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    coronavaccineservice coronavaccineservice;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("records", coronavaccineservice.getRecords());
        return "home";
    }

}
