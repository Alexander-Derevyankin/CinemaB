package cinema.cronc.repositorys;

import cinema.cronc.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
