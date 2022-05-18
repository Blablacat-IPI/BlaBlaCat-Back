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
    public Integer pageMax() {
        //uniquement avec user 10 pour le moment, rajouter le @Request param user id et changer dans service d'angular plus tard
        return reservationService.numberPageMaxReservationByUser();
    }

    @GetMapping("Page")
    public List<ReservationDto> Page(@RequestParam Integer page){
<<<<<<< HEAD
        Integer size = 3;
        return reservationService.getAllReservationsPage(page, size);

=======
        Integer size = 5;
        //uniquement avec user 10 pour le moment, rajouter le @Request param user id et changer dans service d'angular plus tard
        return reservationService.getAllReservationsByUserPage(page, size);
>>>>>>> 14819cf71d5e32ef2bf4e1cedc09740e11ad0ca0
    }



}
