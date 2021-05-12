package cinema.cronc.services;

import cinema.cronc.models.Film;

import java.util.List;

public interface FilmServices {
    public List<Film> getAllFilm();
    public void addFilm(Film film);
    public void updateFilm(Film film);
    public Film getFilmById(Long id);
    public void removeFilm(Long id);
    public boolean existsFilm(Long id);
}
