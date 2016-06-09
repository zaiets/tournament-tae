package models.entity.competition;


import models.entity.basic.Tournament;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@Entity
@Table(name = "EVENTS")
public class SparringEvent implements IEvent {
    @Id
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
    @JoinColumn(name = "TOURNAMENT_ID")
    private Tournament tournament;
    @ManyToOne
    @JoinColumn(name = "DISCIPLINE_ID")
    private Discipline discipline;

    //sparring unique fields
    @OneToOne
    @JoinColumn(name = "WINNER_ID")
    private Sparrer winnerOfPair;
    @Basic
    @Column(name = "PHASE")
    private Integer phase;


    public SparringEvent() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Set<Sparrer> getSparrers() {
        return sparrers;
    }

    @Override
    public void setSparrers(Set<Sparrer> sparrers) {
        this.sparrers = sparrers;
    }

    @Override
    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    @Override
    public Dojang getDojang() {
        return dojang;
    }

    @Override
    public void setDojang(Dojang dojang) {
        this.dojang = dojang;
    }

    @Override
    public Tournament getTournament() {
        return tournament;
    }

    @Override
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Sparrer getWinnerOfPair() {
        return winnerOfPair;
    }

    public void setWinnerOfPair(Sparrer winnerOfPair) {
        this.winnerOfPair = winnerOfPair;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    @Override
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SparringEvent)) return false;

        SparringEvent that = (SparringEvent) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSparrers() != null ? !getSparrers().equals(that.getSparrers()) : that.getSparrers() != null)
            return false;
        if (getTimeOfEvent() != null ? !getTimeOfEvent().equals(that.getTimeOfEvent()) : that.getTimeOfEvent() != null)
            return false;
        if (getDojang() != null ? !getDojang().equals(that.getDojang()) : that.getDojang() != null) return false;
        if (getTournament() != null ? !getTournament().equals(that.getTournament()) : that.getTournament() != null)
            return false;
        if (getDiscipline() != that.getDiscipline()) return false;
        if (getWinnerOfPair() != null ? !getWinnerOfPair().equals(that.getWinnerOfPair()) : that.getWinnerOfPair() != null)
            return false;
        return getPhase() != null ? getPhase().equals(that.getPhase()) : that.getPhase() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        result = 31 * result + (getTimeOfEvent() != null ? getTimeOfEvent().hashCode() : 0);
        result = 31 * result + (getDojang() != null ? getDojang().hashCode() : 0);
        result = 31 * result + (getTournament() != null ? getTournament().hashCode() : 0);
        result = 31 * result + (getDiscipline() != null ? getDiscipline().hashCode() : 0);
        result = 31 * result + (getWinnerOfPair() != null ? getWinnerOfPair().hashCode() : 0);
        result = 31 * result + (getPhase() != null ? getPhase().hashCode() : 0);
        return result;
    }
}
