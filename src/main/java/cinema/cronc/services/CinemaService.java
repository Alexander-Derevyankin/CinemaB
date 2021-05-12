package cinema.cronc.services;

import cinema.cronc.models.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
    public List<Cinema> getAllCinema();
    public void addCinema(Cinema cinema);
    public void updateCinema(Cinema cinema);
    public Cinema getCinemaById(Long id);
    public void removeCinema(Long id);
    public boolean existsCinema(Long id);
}
