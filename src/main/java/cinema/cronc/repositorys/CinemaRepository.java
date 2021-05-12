package cinema.cronc.repositorys;

import cinema.cronc.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository  extends JpaRepository<Cinema, Long> {
}
