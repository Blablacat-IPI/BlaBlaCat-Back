package com.example.blablacat.controller;

import com.example.blablacat.dto.UserCookieDto;
import com.example.blablacat.services.IAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Auth")
public class AuthentificationController {

    @Autowired
    private IAuthentificationService service;


    @GetMapping("Login")
    public ResponseEntity<Boolean> login(@RequestParam String email, @RequestParam String password) {

        if (email.length() < 1 || password.length() < 1) {
            return new ResponseEntity("Un des champs est vide", HttpStatus.BAD_REQUEST);
        }

        try {
            Boolean response = service.login(email, password);
            if (response) {
                return new ResponseEntity(response, HttpStatus.OK);
            } else {
                return new ResponseEntity("Identifiant incorrect", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("Usercookie")
    public UserCookieDto getInfosToCookie(@RequestParam String email) {
        return service.getInfoFromUser(email);
    }

}
