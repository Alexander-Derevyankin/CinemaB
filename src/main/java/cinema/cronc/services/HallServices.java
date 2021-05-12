package cinema.cronc.services;

import cinema.cronc.models.Hall;

import java.util.List;

public interface HallServices {
    public List<Hall> getAllHall();
    public void addHall(Hall hall);
    public void updateHall(Hall hall);
    public Hall getHallById(Long id);
    public void removeHall(Long id);
    public boolean existsHall(Long id);
}
