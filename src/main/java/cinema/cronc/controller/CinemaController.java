package cinema.cronc.controller;

import cinema.cronc.models.Cinema;
import cinema.cronc.services.CinemaServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/cinema", produces = MediaType.APPLICATION_JSON_VALUE)
public class CinemaController {

    @Autowired
    private CinemaServicesImpl cinemaServices;



//    Get
    @GetMapping()
    public ResponseEntity<?> getAllCinema() {
        List<?> allCinema = cinemaServices.getAllCinema();
        return new ResponseEntity<>(allCinema, HttpStatus.OK);
    }


//    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCinemaById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cinema cinema = cinemaServices.getCinemaById(id);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }


//    Post
    @PostMapping(value = "")
    public ResponseEntity<?> setCinema(@RequestBody Cinema cinema){
        if (cinema == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        cinemaServices.addCinema(cinema);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }


//    Put
    @PutMapping(value = "")
    public ResponseEntity<?> updateCinema(@RequestBody Cinema cinema){
        if (cinema == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        cinemaServices.updateCinema(cinema);
        return new ResponseEntity<>(cinema, HttpStatus.UPGRADE_REQUIRED);
    }


//    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        cinemaServices.removeCinema(id);
        return new ResponseEntity<>("Deleted Ok", HttpStatus.OK);
    }
}
