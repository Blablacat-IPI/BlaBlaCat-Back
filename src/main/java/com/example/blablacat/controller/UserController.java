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

    @PostMapping("addUser")
    public ResponseEntity<Integer> addUsers(@RequestBody UserDto udto) {

        Integer id = service.addUsers( udto.getUsername(), udto.getIdCompany(), udto.getLastName(), udto.getFirstName(), udto.getPassword(), udto.getEmail());

        try {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteUser")
    public void deleteUsers(@PathVariable("id") Integer id) {
        service.deleteUser(id);
    }
}
