package cinema.cronc.controller;

import cinema.cronc.models.Film;
import cinema.cronc.services.FilmServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/film", produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmController {

    @Autowired
    private FilmServicesImpl filmServices;

//    Get
    @GetMapping()
    public ResponseEntity<?> getAllFilm(){
        return new ResponseEntity<>(filmServices.getAllFilm(), HttpStatus.OK);
    }

//    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(filmServices.getFilmById(id), HttpStatus.OK);
    }

//    Post
    @PostMapping()
    public ResponseEntity<?> setFilm(@RequestBody Film film){
        if (film == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        filmServices.addFilm(film);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

//    Put
    @PutMapping
    public ResponseEntity<?> updateFilm(@RequestBody Film film){
        if (film == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        filmServices.updateFilm(film);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }


//    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletedFilm(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        filmServices.removeFilm(id);
        return new ResponseEntity<>("Deleted OK", HttpStatus.OK);
    }


}
