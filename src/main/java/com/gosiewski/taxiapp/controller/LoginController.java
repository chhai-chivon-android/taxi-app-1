package com.gosiewski.taxiapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class LoginController {

    @RequestMapping(value = "/test")
    public ResponseEntity<String> testEndpoint() {
        return new ResponseEntity<>("Test completed successfully!", HttpStatus.OK);
    }
}
