package cinema.cronc.services;

import cinema.cronc.models.Cinema;
import cinema.cronc.repositorys.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServicesImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    @Override
    public void addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public void updateCinema(Cinema cinemaDetail) {
        cinemaRepository.save(cinemaDetail);
    }

    @Override
    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseGet(Cinema::new);
    }

    @Override
    public void removeCinema(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public boolean existsCinema(Long id) {
        return cinemaRepository.existsById(id);
    }
}
