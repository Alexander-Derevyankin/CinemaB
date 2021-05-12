package cinema.cronc.services;

import cinema.cronc.models.Film;
import cinema.cronc.repositorys.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class FilmServicesImpl implements FilmServices {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @Override
    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void updateFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseGet(Film::new);
    }

    @Override
    public void removeFilm(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public boolean existsFilm(Long id) {
        return filmRepository.existsById(id);
    }
}
