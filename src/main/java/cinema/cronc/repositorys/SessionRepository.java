package cinema.cronc.repositorys;

import cinema.cronc.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query(value = "SELECT * FROM session WHERE film_id = :id", nativeQuery = true)
    List<Session> findAllSessionByFilm(Long id);
    @Query(value = "SELECT * FROM session WHERE cinema_id = :id", nativeQuery = true)
    List<Session> findAllSessionByCinema(Long id);
}
