package com.myexam.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    //expose "/" that return "Hello Controller"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}