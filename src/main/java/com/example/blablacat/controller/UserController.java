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

    @GetMapping("getById")
    public UserDto getById(@RequestParam Integer id){return service.getById(id);}

    @PostMapping("updateUser")
    public void updateUser(@RequestBody UserDto dto){
        if(service.checkExistById(dto.getId())){
            service.updateUser(dto);
        }
    }

    @GetMapping("email/{driverUsername}")
    public ResponseEntity<String> getDriverEmail(@PathVariable String driverUsername){
        System.out.println("dans controller");
        try {
            String reponse = this.service.getUserEmailByUsername(driverUsername);
            return new ResponseEntity(reponse, HttpStatus.OK);
        } catch (Exception e ){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("usernameCheckVacant")
    public Boolean checkUsernameVacant(@RequestParam String username){
        if(service.checkUsernameUsed(username)){
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("companyIdCheckVacant")
    public Boolean checkCompanyIdVacant(@RequestParam String companyId){

        if(service.checkCompanyIdUsed(companyId)){
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("emailCheckVacant")
    public Boolean checkEmailVacant(@RequestParam String email){
        if(service.checkEmailUsed(email)){
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("all")
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("allValid")
    public List<UserDto> getAllValid(){
        return service.getAllValidUsers();
    }

    @GetMapping("allUnvalid")
    public List<UserDto> getAllUnvalid() {
        return service.getAllUnvalidUsers();
    }

    @PostMapping("addUser")
    public ResponseEntity<Integer> addUsers(@RequestBody UserDto udto) {

        try {
            Integer id = service.addUser( udto.getUsername(), udto.getIdCompany(), udto.getLastName(), udto.getFirstName(), udto.getPassword(), udto.getEmail());
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("validateByAdmin/{id}")
    public ResponseEntity<Boolean> validateByAdmin(@PathVariable("id") Integer id) {

        try {
            if(service.checkExistById(id)){
                Boolean reponse = service.validateUserByAdmin(id);
                return new ResponseEntity(reponse, HttpStatus.OK);
            }else{
                return new ResponseEntity("Cet User n'existe pas", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
    }

    @DeleteMapping("softDeleteUser/{id}")
    public void softDeleteUser(@PathVariable("id") Integer id) {

        if (service.checkExistById(id)){
            service.softDeleteUser(id);
        }

    }

    @GetMapping("pageMaxUsersNotValidate")
    public Integer pageMaxUsersNotValidate() {
        return service.numberPageMaxOfUsersNotValidate();
    }

    @GetMapping("pageUsersNotValidate")
    public List<UserDto> pageUsersNotValidate(@RequestParam Integer page) {
        Integer size = 10;
        return service.getAllUsersNotValidateByPages(page, size);
    }

    @GetMapping("pageMaxUsersValidate")
    public Integer pageMaxUsersValidate() {
        return service.numberPageMaxOfUsersValidate();
    }

    @GetMapping("pageUsersValidate")
    public List<UserDto> pageUsersValidate(@RequestParam Integer page) {
        Integer size = 10;
        return service.getAllUsersValidateByPages(page, size);
    }

}
