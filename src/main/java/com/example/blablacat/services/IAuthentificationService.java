package com.example.blablacat.services;

import com.example.blablacat.dto.TokenDto;
import com.example.blablacat.dto.UserDto;

public interface IAuthentificationService{

    TokenDto tokentoDto(String token);

}
