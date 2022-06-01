package com.example.blablacat.services;

import com.example.blablacat.dto.TokenDto;
import com.example.blablacat.dto.UserCookieDto;
import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;

public interface IAuthentificationService{


    Boolean login(String email, String password);

    UserCookieDto toDto(UserEntity entity);

    UserCookieDto getInfoFromUser(String email);

}
