package ru.summer.mymarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    //  http://localhost:8088/summer/
    @GetMapping
    public String MainPage() {
        return "mainPage";
    }



}
