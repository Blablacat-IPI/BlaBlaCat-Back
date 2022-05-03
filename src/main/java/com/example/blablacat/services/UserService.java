package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private RepositoryUser repository;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto udto = new UserDto();
        udto.setLastName(entity.getLastName());
        udto.setFirstName(entity.getFirstName());
        udto.setUsername(entity.getUsername());
        udto.setEmail(entity.getEmail());
        udto.setPassword(entity.getPassword());

        return udto;


    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserEntity> list = repository.findAll();
        List<UserDto> listDto = new ArrayList<>();

        for(UserEntity ue : list){
            listDto.add(this.toDto(ue));
        }

        return listDto;
    }

    @Override
    public Integer addUsers(String lastName, String firstName, String username, String idCompany, String email, String password) {
        UserEntity ue = new UserEntity();
        ue.setLastName(lastName);
        ue.setFirstName(firstName);
        ue.setUsername(username);
        ue.setIdCompany(idCompany);
        ue.setEmail(email);
        ue.setPassword(password);

        ue.setCreatedAt(LocalDateTime.now());
        ue.setUpdateAt(LocalDateTime.now());

        repository.saveAndFlush(ue);
        return ue.getId();
    }


}
