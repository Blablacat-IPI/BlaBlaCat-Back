package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserDto toDto(UserEntity entity);

    List<UserDto> getAllUsers();

    Integer addUsers(String username, String idCompany, String lastName, String firstName, String password, String email);

    void deleteUser(Integer id);

}
