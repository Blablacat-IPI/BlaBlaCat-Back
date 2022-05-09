package com.example.blablacat.controller;

import com.example.blablacat.dto.AddUserToCourseDto;
import com.example.blablacat.entity.UserHasCourseEntity;
import com.example.blablacat.repository.UserHasCourseRepository;
import com.example.blablacat.services.IUserHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("UserHasCourse")
public class UserHasCourseController {
    @Autowired
    private IUserHasCourseService userHasCourseService;

    @Autowired
    private UserHasCourseRepository userHasCourseRepository;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody AddUserToCourseDto userHasCourseDto){
        Integer id = userHasCourseService.save(userHasCourseDto);
        return new ResponseEntity(id, HttpStatus.OK);
    };

    @GetMapping("get/{id}")
    public ResponseEntity<AddUserToCourseDto> get (@PathVariable String id) {
        Integer ID = Integer.valueOf(id);
        if(!userHasCourseService.exists(ID)){
            return new ResponseEntity("Trajet non trouvé", HttpStatus.NOT_FOUND);
        }
        AddUserToCourseDto dto = userHasCourseService.get(ID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("all")
    public List<AddUserToCourseDto> all(){
        List<UserHasCourseEntity> list = userHasCourseRepository.findAll();
        List<AddUserToCourseDto> listFinal = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            UserHasCourseEntity entity = list.get(i);
            AddUserToCourseDto dto = userHasCourseService.toDto(entity);
            listFinal.add(dto);
        }
        return listFinal;
    }

}
