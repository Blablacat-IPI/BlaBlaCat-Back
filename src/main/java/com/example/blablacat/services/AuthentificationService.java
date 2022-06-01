package com.example.blablacat.services;

import com.example.blablacat.dto.TokenDto;
import com.example.blablacat.dto.UserCookieDto;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.repository.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;


@Service
public class AuthentificationService implements IAuthentificationService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean login(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public UserCookieDto toDto(UserEntity entity) {
        UserCookieDto ucdto = new UserCookieDto();
        ucdto.setId(entity.getId());
        ucdto.setUsername(entity.getUsername());
        ucdto.setRole(entity.getRole());
        return ucdto;
    }

    @Override
    public UserCookieDto getInfoFromUser(String email) {
        UserEntity entity = userRepository.getByEmail(email);
        UserCookieDto dto = this.toDto(entity);

        return dto;
    }


}
