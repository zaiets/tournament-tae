package models.entity.competition;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Table(name = "DISCIPLINES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NAME")})
public class Discipline {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME", nullable=false)
    private String name;
    @OneToMany(mappedBy = "discipline")
    private List<Event> events;
    @ManyToMany
    @JoinTable(name = "SPARRERS_DISCIPLINES",
            joinColumns = @JoinColumn(name = "DISCIPLINE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPARRER_ID"))
    private Set<Sparrer> sparrers;

    public Discipline() {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Set<Sparrer> getSparrers() {
        return sparrers;
    }

    public void setSparrers(Set<Sparrer> sparrers) {
        this.sparrers = sparrers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;

        Discipline that = (Discipline) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getEvents() != null ? !getEvents().equals(that.getEvents()) : that.getEvents() != null) return false;
        return getSparrers() != null ? getSparrers().equals(that.getSparrers()) : that.getSparrers() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEvents() != null ? getEvents().hashCode() : 0);
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        return result;
    }
}
