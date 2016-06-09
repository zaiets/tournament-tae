package models.entity.competition;

import models.entity.basic.Tournament;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Table(name = "DOJANGS")
public class Dojang {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "EVENTS")
    private List<IEvent> eventsList;
    @ManyToOne
    @JoinColumn(name = "TOURNAMENT_ID")
    private Tournament tournament;

    public Dojang() {
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

    public List<IEvent> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<IEvent> eventsList) {
        this.eventsList = eventsList;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dojang)) return false;

        Dojang dojang = (Dojang) o;

        if (getId() != null ? !getId().equals(dojang.getId()) : dojang.getId() != null) return false;
        if (getName() != null ? !getName().equals(dojang.getName()) : dojang.getName() != null) return false;
        if (getEventsList() != null ? !getEventsList().equals(dojang.getEventsList()) : dojang.getEventsList() != null)
            return false;
        return getTournament() != null ? getTournament().equals(dojang.getTournament()) : dojang.getTournament() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEventsList() != null ? getEventsList().hashCode() : 0);
        result = 31 * result + (getTournament() != null ? getTournament().hashCode() : 0);
        return result;
    }
}
