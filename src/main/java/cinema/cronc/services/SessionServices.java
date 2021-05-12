package cinema.cronc.services;


import cinema.cronc.models.Session;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface SessionServices {
    public List<Session> getAllSession();
    public void addSession(Session session);
    public void updateSession(Session session);
    public Session getSessionById(Long id);
    public void removeSession(Long id);
    public boolean existsSession(Long id);
    public Map<String,List<Session>> findAllSessionByFilm(Long id);
    public Map<String,List<Session>> findAllSessionByCinema(Long id);
}
