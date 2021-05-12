package cinema.cronc.controller;

import cinema.cronc.models.Hall;
import cinema.cronc.services.HallServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/hall", produces = MediaType.APPLICATION_JSON_VALUE)
public class HallController {

    @Autowired
    private HallServicesImpl hallServices;

//    Get
    @GetMapping()
    public ResponseEntity<?> getAllHall() {
        List<?> allHall = hallServices.getAllHall();
        return new ResponseEntity<>(allHall, HttpStatus.OK);
    }

//    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHallById(@PathVariable Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Hall hall = hallServices.getHallById(id);
        return  new ResponseEntity<>(hall, HttpStatus.OK);
    }

//    Post
    @PostMapping()
    public ResponseEntity<?> setHall(@RequestBody Hall hall){
        if (hall == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        hallServices.addHall(hall);
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }

//    Put
    @PutMapping()
    public ResponseEntity<?> updateHall(@RequestBody Hall hall){
        if (hall == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        hallServices.updateHall(hall);
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }

//    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteHall(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        hallServices.removeHall(id);
        return new ResponseEntity<>("Deleted OK", HttpStatus.OK);
    }

}
