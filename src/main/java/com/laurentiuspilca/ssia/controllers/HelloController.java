package com.laurentiuspilca.ssia.controllers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@RestController
@Controller
public class HelloController {

    //context - null poitnter exception we need use MODE_INHERITABLETHREADLOCAL  strategy
    //SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL)
    // or properties file spring.security.strategy=...
//    @Async
//    public void goodbye(){
//        SecurityContext context = SecurityContextHolder.getContext();
//        String name = context.getAuthentication().getName();
//
//    }

    @GetMapping("/hello")
    public String hello(Authentication authentication ){
//        SecurityContext context= SecurityContextHolder.getContext();
//        Authentication authentication=context.getAuthentication();
        Object credentials = authentication.getCredentials();
        String password = (String) credentials;
        if(password==null)
            password="";
        System.out.println("Hello, "
                + authentication.getName()
                + " credentions: "
                +password);
        return "Hello!";
    }

    @GetMapping("/home")
    public String home(){
        return "home.html";
    }

}
