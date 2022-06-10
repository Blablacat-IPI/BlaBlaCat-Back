package com.example.blablacat.controller;

import com.example.blablacat.dto.UserCookieDto;
import com.example.blablacat.services.IAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://blablacat.vercel.app/")
@RequestMapping("Auth")
public class AuthentificationController {

    @Autowired
    private IAuthentificationService service;


    @GetMapping("Login")
    public ResponseEntity<Integer> login(@RequestParam String email, @RequestParam String password) {

        if (email.length() < 1 || password.length() < 1) {
            return new ResponseEntity("Un des champs est vide", HttpStatus.BAD_REQUEST);
        }

        try {
            Integer response = service.login(email, password);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("Usercookie")
    public UserCookieDto getInfosToCookie(@RequestParam String email) {
        return service.getInfoFromUser(email);
    }

}
