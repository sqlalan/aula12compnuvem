package com.senai.aula12compnuvem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Aula 12 - Computação em Nuvem - Deploy na Railway";
    }
}
