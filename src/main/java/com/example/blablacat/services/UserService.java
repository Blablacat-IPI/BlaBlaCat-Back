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
    private UserRepository userRepository;

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

        List<UserEntity> list = userRepository.findAll();
        List<UserDto> listDto = new ArrayList<>();

        for(UserEntity ue : list){
            listDto.add(this.toDto(ue));
        }

        return listDto;
    }

    @Override
    public List<UserDto> getAllValidUsers() {
        List<UserEntity> list = userRepository.findAllByValidateAdminTrueAndDeletedAtNull();
        List<UserDto> listDto = new ArrayList<>();

        for(UserEntity ue : list){
            listDto.add(this.toDto(ue));
        }
        return listDto;
    }

    public List<UserDto> getAllUnvalidUsers(){

        List<UserEntity> list = userRepository.findAllByValidateAdminNull();
        List<UserDto> listDto = new ArrayList<>();

        for(UserEntity ue : list){
            listDto.add(this.toDto(ue));
        }

        return listDto;
    }

    @Override
    public Integer addUser(String username, String idCompany, String lastName, String firstName, String password, String email) {
        UserEntity entity = new UserEntity();
        entity.setUsername(username);
        entity.setIdCompany(idCompany);
        entity.setLastName(lastName);
        entity.setFirstName(firstName);
        entity.setPassword(password);
        entity.setEmail(email);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());

        userRepository.saveAndFlush(entity);

        return entity.getId();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //rajouter le control exist() dans le controller
    @Override
    public void softDeleteUser(Integer id) {
        UserEntity entity = userRepository.findById(id).get();
        entity.setDeletedAt(LocalDateTime.now());
        userRepository.save(entity);
    }

    @Override
    public Boolean validateUserByAdmin(Integer id){
        UserEntity entity = userRepository.findById(id).get();
        entity.setValidateAdmin(true);
        userRepository.save(entity);
        return true;
    }

    public Boolean checkExistById(Integer id){
        return userRepository.existsById(id);
    }

}
