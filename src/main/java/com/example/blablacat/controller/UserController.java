package com.example.blablacat.controller;



import com.example.blablacat.dto.UserDto;
import com.example.blablacat.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("all")
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    //getAllUnvalidUsers
    @GetMapping("allUnvalid")
    public List<UserDto> getAllUnvalid() {
        return service.getAllUnvalidUsers();
    }


    @PostMapping("addUser")
    public ResponseEntity<Integer> addUsers(@RequestBody UserDto uDto) {

        try {
            Integer id = service.addUsers(uDto.getLastName(), uDto.getFirstName(), uDto.getIdCompany(), uDto.getUsername(), uDto.getEmail(), uDto.getPassword());
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("validateByAdmin")
    public ResponseEntity<Boolean> validateByAdmin(@RequestBody UserDto uDto) {

        try {
            Boolean reponse = service.validateUserByAdmin(uDto);
            System.out.println("jusqu'ici ça va");
            return new ResponseEntity(reponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
