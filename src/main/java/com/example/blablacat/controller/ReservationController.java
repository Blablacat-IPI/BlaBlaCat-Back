package com.example.blablacat.controller;

import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.repository.ReservationRepository;
import com.example.blablacat.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("Reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ReservationRepository userHasCourseRepository;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody ReservationDto userHasCourseDto){
        Integer id = reservationService.save(userHasCourseDto);
        return new ResponseEntity(id, HttpStatus.OK);
    };

    @GetMapping("get/{id}")
    public ResponseEntity<ReservationDto> get (@PathVariable String id) {
        Integer ID = Integer.valueOf(id);
        if(!reservationService.exists(ID)){
            return new ResponseEntity("Trajet non trouvé", HttpStatus.NOT_FOUND);
        }
        ReservationDto dto = reservationService.get(ID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("all")
    public List<ReservationDto> all(){
        List<ReservationEntity> list = userHasCourseRepository.findAll();
        List<ReservationDto> listFinal = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            ReservationEntity entity = list.get(i);
            ReservationDto dto = reservationService.toDto(entity);
            listFinal.add(dto);
        }
        return listFinal;
    }

}
