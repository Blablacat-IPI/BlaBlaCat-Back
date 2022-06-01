package com.example.blablacat.services;

import com.example.blablacat.dto.TokenDto;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.example.blablacat.dto.UserDto;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;


@Service
public class AuthentificationService implements IAuthentificationService {


    @Override
    public TokenDto tokentoDto(String token) {
        //Hey Google tu connais cette personne ?
        HttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Arrays.asList("1003141166599-klctaq9cljfd9m4k3hdn7t5e2fmfgmbq.apps.googleusercontent.com")).build();

        //Google répond : tien voilà ma réponse :
        GoogleIdToken response = null;
        try {
            //C'est un bon gars lui
            response = verifier.verify(token);
        } catch (GeneralSecurityException e) {
            //C'est pas un bon gars, beurk
            return null;
        } catch (IOException e) {
            //euh je sais pas en faite ce que ca veut dire ^^
            return null;
        }

        //On sait jamais il faut tjs vérifier une deuxieme fois, est-ce que ton gars existe ? car je suis pas doué
        if (null == token)
            //En effet je suis nul, c'est pas un bon gars beurk²
            return null;

        //Tien voilà mes données en payload, en gros voilà 14 info pour toi c'est gentil non ?
        GoogleIdToken.Payload payload = response.getPayload();

        TokenDto dto = new TokenDto();
        dto.setEmail(payload.getEmail());
        dto.setNom((String) payload.get("given_name"));
        dto.setPrenom((String) payload.get("family_name"));
        dto.setImageUrl((String) payload.get("picture"));

        return dto;
    }
}
