package com.example.blablacat.controller;

import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("Reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody ReservationDto reservationDto){
        System.out.println(reservationDto.getUser_id());
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
      return reservationService.getAllReservations();
    }

    @GetMapping("pagemax")
    public Integer pageMax(@RequestParam Integer userId) {
        return reservationService.numberPageMaxReservationByUser(userId);
    }

    @GetMapping("Page")
    public List<ReservationDto> Page(@RequestParam Integer page, @RequestParam Integer userId){
        Integer size = 5;
        return reservationService.getAllReservationsByUserPage(page, size, userId);

    }



}
