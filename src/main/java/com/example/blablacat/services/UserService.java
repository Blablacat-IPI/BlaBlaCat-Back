package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto udto = new UserDto();
        udto.setId(entity.getId());
        udto.setLastName(entity.getLastName());
        udto.setFirstName(entity.getFirstName());
        udto.setIdCompany(entity.getIdCompany());
        udto.setUsername(entity.getUsername());
        udto.setEmail(entity.getEmail());
        udto.setPassword(entity.getPassword());
        udto.setIdCompany(entity.getIdCompany());

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

    public List<UserDto> getAllUnvalidUsers(){

        List<UserEntity> list = repository.findAllByValidateAdminNull();
        List<UserDto> listDto = new ArrayList<>();

        for(UserEntity ue : list){
            listDto.add(this.toDto(ue));
        }

        return listDto;
    }

    @Override
    public Integer addUsers(String username, String idCompany, String lastName, String firstName, String password, String email) {
        UserEntity ue = new UserEntity();
        ue.setUsername(username);
        ue.setIdCompany(idCompany);
        ue.setLastName(lastName);
        ue.setFirstName(firstName);
        ue.setPassword(password);
        ue.setEmail(email);


        ue.setCreatedAt(LocalDateTime.now());
        ue.setUpdateAt(LocalDateTime.now());

        repository.saveAndFlush(ue);
        System.out.println(ue.getIdCompany());
        return ue.getId();
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void softDeleteUser(Integer id) {
        //rajouter le control exist() dans le controller
        UserEntity entity = repository.findById(id).get();


    }


    @Override
    public Boolean validateUserByAdmin(UserDto dto){
        //rajouter control exist() dans le controller
        UserEntity entity = repository.findByUsername(dto.getUsername()).get();
        entity.setValidateAdmin(true);
        repository.save(entity);
        return true;
    }


}
