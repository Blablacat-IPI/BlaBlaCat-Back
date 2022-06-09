package com.example.blablacat.controller;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.NewReservationDto;
import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="https://blablacat.vercel.app")
@RestController
@RequestMapping("Reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody NewReservationDto newReservationDto){

        try {
            Integer id = reservationService.save(newReservationDto.getCourse(), newReservationDto.getUserId());
            return new ResponseEntity(id, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

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

    @DeleteMapping("delete/{courseId}/{userId}")
    public void delete(@PathVariable("courseId") Integer courseId, @PathVariable("userId") Integer userId){
        System.out.println("Dnas controller");
        this.reservationService.deleteReservation(courseId, userId);

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
