package cinema.cronc.controller;

import cinema.cronc.models.Session;
import cinema.cronc.services.SessionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/session", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {

    @Autowired
    private SessionServices sessionServices;


//    Get
    @GetMapping
    public ResponseEntity<?> getAllSession(){
        return new ResponseEntity<>(sessionServices.getAllSession(), HttpStatus.OK);
    }


//    Get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getSessionByID(@PathVariable Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sessionServices.getSessionById(id), HttpStatus.OK);
    }

//    Get films' session
    @GetMapping(value = "/film/{id}")
    public ResponseEntity<?> findAllSessionByFilm(@PathVariable Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sessionServices.findAllSessionByFilm(id), HttpStatus.OK);
    }
//    Get cinemas' session
    @GetMapping(value = "/cinema/{id}")
    public ResponseEntity<?> findAllSessionByCinema(@PathVariable Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sessionServices.findAllSessionByCinema(id), HttpStatus.OK);
    }


//    Post
    @PostMapping
    public ResponseEntity<?> setSession(@RequestBody Session session) {
        if (session == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        sessionServices.addSession(session);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }


//    Put
    @PutMapping
    public ResponseEntity<?> updateSession(@RequestBody Session session) {
        if (session == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        sessionServices.updateSession(session);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }


//    Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable Long id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        sessionServices.removeSession(id);
        return new ResponseEntity<>("Deleted OK", HttpStatus.OK);
    }


}
