package com.example.blablacat.controller;

import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.repository.ReservationRepository;
import com.example.blablacat.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private ReservationRepository reservationRepository;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody ReservationDto reservationDto){
        Integer id = reservationService.save(reservationDto);
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
      return reservationService.getAllCourses();
    }

    @GetMapping("Page")
    public List<ReservationDto> Page(@RequestParam Integer page, Integer size){
        return reservationService.getAllCoursesPage(page, size);
    }


}
