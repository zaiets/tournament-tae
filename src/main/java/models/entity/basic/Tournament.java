package models.entity.basic;


import models.entity.competition.Dojang;
import models.entity.competition.IEvent;
import models.entity.competition.Sparrer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@Entity
@Table(name = "TOURNAMENTS")
public class Tournament {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @OneToMany(mappedBy = "DOJANGS")
    private Set<Dojang> dojangs;
    @OneToMany(mappedBy = "SPARRERS")
    private Set<Sparrer> sparrers;
    @OneToMany(mappedBy = "EVENTS")
    private Set<IEvent> events;

    public Tournament() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Set<Dojang> getDojangs() {
        return dojangs;
    }

    public void setDojangs(Set<Dojang> dojangs) {
        this.dojangs = dojangs;
    }

    public Set<Sparrer> getSparrers() {
        return sparrers;
    }

    public void setSparrers(Set<Sparrer> sparrers) {
        this.sparrers = sparrers;
    }

    public Set<IEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<IEvent> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tournament)) return false;

        Tournament that = (Tournament) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getDojangs() != null ? !getDojangs().equals(that.getDojangs()) : that.getDojangs() != null) return false;
        if (getSparrers() != null ? !getSparrers().equals(that.getSparrers()) : that.getSparrers() != null)
            return false;
        return getEvents() != null ? getEvents().equals(that.getEvents()) : that.getEvents() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getDojangs() != null ? getDojangs().hashCode() : 0);
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        result = 31 * result + (getEvents() != null ? getEvents().hashCode() : 0);
        return result;
    }
}
