package com.secure.rest_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    @GetMapping("/hello")
    public ResponseEntity<String> heyThere()
    {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}
