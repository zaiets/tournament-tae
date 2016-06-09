package models.entity.competition;


import models.entity.basic.Tournament;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public interface IEvent {
    Integer getId ();
    void setId (Integer id);
    Set<Sparrer> getSparrers ();
    void setSparrers (Set<Sparrer> sparrers);
    LocalDateTime getTimeOfEvent();
    void setTimeOfEvent(LocalDateTime timeOfEvent);
    Dojang getDojang();
    void setDojang(Dojang dojang);
    Tournament getTournament();
    void setTournament(Tournament tournament);
    Discipline getDiscipline ();
    void setDiscipline(Discipline discipline);
}
