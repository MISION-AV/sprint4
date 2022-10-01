package edu.udea.sprint4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

    //Método para llamar la página home.html
    @GetMapping({"/", "/index", "/home"})
    public String index(){
        return "home";
    }
}
