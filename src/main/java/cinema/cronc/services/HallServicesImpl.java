package cinema.cronc.services;

import cinema.cronc.models.Hall;
import cinema.cronc.repositorys.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServicesImpl implements HallServices {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    @Override
    public void addHall(Hall hall) {
        hallRepository.save(hall);
    }

    @Override
    public void updateHall(Hall hallDetail) {
//        Hall hall = hallRepository.findById(hallDetail.getId()).orElseGet(Hall::new);
//        hall.setCount(hallDetail.getCount());
//        hall.setType(hallDetail.getType());
        hallRepository.save(hallDetail);
    }

    @Override
    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElseGet(Hall::new);
    }

    @Override
    public void removeHall(Long id) {
        hallRepository.deleteById(id);
    }

    @Override
    public boolean existsHall(Long id) {
        return hallRepository.existsById(id);
    }
}
