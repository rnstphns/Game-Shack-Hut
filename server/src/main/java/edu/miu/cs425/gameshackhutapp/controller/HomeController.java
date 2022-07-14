package edu.miu.cs425.gameshackhutapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value={"/home", "/home"})
    public String home(){
        return "public/index";
    }

}
