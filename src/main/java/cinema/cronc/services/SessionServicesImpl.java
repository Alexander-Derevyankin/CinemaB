package cinema.cronc.services;

import cinema.cronc.models.Cinema;
import cinema.cronc.models.Film;
import cinema.cronc.models.Hall;
import cinema.cronc.models.Session;
import cinema.cronc.repositorys.CinemaRepository;
import cinema.cronc.repositorys.FilmRepository;
import cinema.cronc.repositorys.HallRepository;
import cinema.cronc.repositorys.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionServicesImpl implements SessionServices {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private HallServices hallServices;
    @Autowired
    private FilmServices filmServices;
    @Autowired
    private CinemaService cinemaService;

    @Override
    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }

    @Override
    public void addSession(Session sessionDetail) {
        Cinema cinema = cinemaService.getCinemaById(sessionDetail.getCinema().getId());
        Film film = filmServices.getFilmById(sessionDetail.getFilm().getId());
        Hall hall = hallServices.getHallById(sessionDetail.getHall().getId());

        sessionDetail.setCinema(cinema);
        sessionDetail.setFilm(film);
        sessionDetail.setHall(hall);

        sessionRepository.save(sessionDetail);
    }

    @Override
    public void updateSession(Session sessionDetail) {
        this.addSession(sessionDetail);
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseGet(Session::new);
    }

    @Override
    public void removeSession(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public boolean existsSession(Long id) {
        return sessionRepository.existsById(id);
    }

    @Override
    public Map<String,List<Session>> findAllSessionByFilm(Long id){
        List<Session> sessions = sessionRepository.findAllSessionByFilm(id);
        Map<String,List<Session>> response = new HashMap<>();
        List<Session> newSess;
        for (Session s: sessions){
            response.putIfAbsent(s.getDate().toString(), new ArrayList<>());
            newSess = response.get(s.getDate().toString());
            newSess.add(s);
            response.put(s.getDate().toString(), newSess);
        }
        return response;
    }
    @Override
    public Map<String,List<Session>> findAllSessionByCinema(Long id){
        List<Session> sessions = sessionRepository.findAllSessionByCinema(id);
        Map<String,List<Session>> response = new HashMap<>();
        List<Session> newSess;
        for (Session s: sessions){
            response.putIfAbsent(s.getDate().toString(), new ArrayList<>());
            newSess = response.get(s.getDate().toString());
            newSess.add(s);
            response.put(s.getDate().toString(), newSess);
        }
        return response;
    }
}
