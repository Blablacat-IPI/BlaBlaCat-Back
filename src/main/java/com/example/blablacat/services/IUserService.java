package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserDto toDto(UserEntity entity);

    List<UserDto> getAllUsers();

    void deleteUser(Integer id);

    List<UserDto> getAllUnvalidUsers();

    Integer addUsers(String lastName, String firstName, String username, String idCompany, String email, String password );

    Boolean validateUserByAdmin(UserDto dto);


}
