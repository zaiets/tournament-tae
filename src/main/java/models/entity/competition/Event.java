package models.entity.competition;


import models.entity.basic.Tournament;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@Entity
@Table(name = "EVENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCIPLINE_ID")
public abstract class Event {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @ManyToMany
    @JoinTable(name = "SPARRERS_EVENTS",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPARRER_ID"))
    private Set<Sparrer> sparrers;
    @Basic
    @Column(name = "TIME")
    private LocalDateTime timeOfEvent;
    @ManyToOne
    @JoinColumn(name = "DOJANG_ID")
    private Dojang dojang;
    @ManyToOne
    @JoinColumn(name = "TOURNAMENT_ID", nullable=false)
    private Tournament tournament;
    @ManyToOne
    @JoinColumn(name = "DISCIPLINE_ID", nullable=false, insertable = false, updatable = false)
    private Discipline discipline;

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Sparrer> getSparrers() {
        return sparrers;
    }

    public void setSparrers(Set<Sparrer> sparrers) {
        this.sparrers = sparrers;
    }

    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public Dojang getDojang() {
        return dojang;
    }

    public void setDojang(Dojang dojang) {
        this.dojang = dojang;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (getId() != null ? !getId().equals(event.getId()) : event.getId() != null) return false;
        if (getSparrers() != null ? !getSparrers().equals(event.getSparrers()) : event.getSparrers() != null)
            return false;
        if (getTimeOfEvent() != null ? !getTimeOfEvent().equals(event.getTimeOfEvent()) : event.getTimeOfEvent() != null)
            return false;
        if (getDojang() != null ? !getDojang().equals(event.getDojang()) : event.getDojang() != null) return false;
        if (getTournament() != null ? !getTournament().equals(event.getTournament()) : event.getTournament() != null)
            return false;
        return getDiscipline() != null ? getDiscipline().equals(event.getDiscipline()) : event.getDiscipline() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        result = 31 * result + (getTimeOfEvent() != null ? getTimeOfEvent().hashCode() : 0);
        result = 31 * result + (getDojang() != null ? getDojang().hashCode() : 0);
        result = 31 * result + (getTournament() != null ? getTournament().hashCode() : 0);
        result = 31 * result + (getDiscipline() != null ? getDiscipline().hashCode() : 0);
        return result;
    }
}
