package com.udea.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    // hacer home bonito


//    @GetMapping("/cliente")
//    public String cliente(Model model) {
//        return "cliente";
//    }
}
