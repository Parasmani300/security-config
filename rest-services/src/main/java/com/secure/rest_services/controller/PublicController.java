package com.secure.rest_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/notes")
    public ResponseEntity<String> sendPublicNotes()
    {
        return new ResponseEntity<>("The fox is green", HttpStatus.OK);
    }
}
