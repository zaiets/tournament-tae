package models.entity.competition;


import models.definitions.Kup;
import models.entity.basic.Tournament;
import models.entity.basic.Trainer;
import models.entity.basic.WeightCategory;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Table(name = "SPARRERS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "SURNAME"),
                @UniqueConstraint(columnNames = "NAME"),
                @UniqueConstraint(columnNames = "BIRTHDAY")})
public class Sparrer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @ManyToOne
    @JoinColumn(name = "TRAINER_ID")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "FIRST_TRAINER_ID")
    private Trainer firstTrainer;
    @Basic
    @Column(name = "KUP")
    private Kup kup;
    @Basic
    @Column(name = "SEX")
    private Character sex;
    @Basic
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Basic
    @Column(name = "WEIGHT")
    private Integer weight;
    @JoinTable(name = "SPARRERS_DISCIPLINES",
            joinColumns = @JoinColumn(name = "SPARRER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISCIPLINE_ID"))
    private Set<Discipline> disciplines;
    @ManyToOne
    @JoinColumn(name = "TOURNAMENT_ID")
    private Tournament tournament;
    @ManyToOne
    @JoinColumn(name = "WEIGHT_CATEGORY_ID")
    private WeightCategory weightCategory;
    @ManyToMany
    @JoinTable(name = "SPARRERS_EVENTS",
            joinColumns = @JoinColumn(name = "SPARRER_ID"),
            inverseJoinColumns = @JoinColumn(name = "EVENT_ID"))
    private List<Event> events;

    public Sparrer() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getFirstTrainer() {
        return firstTrainer;
    }

    public void setFirstTrainer(Trainer firstTrainer) {
        this.firstTrainer = firstTrainer;
    }

    public Kup getKup() {
        return kup;
    }

    public void setKup(Kup kup) {
        this.kup = kup;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(WeightCategory weightCategory) {
        this.weightCategory = weightCategory;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sparrer)) return false;

        Sparrer sparrer = (Sparrer) o;

        if (getId() != null ? !getId().equals(sparrer.getId()) : sparrer.getId() != null) return false;
        if (getName() != null ? !getName().equals(sparrer.getName()) : sparrer.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(sparrer.getSurname()) : sparrer.getSurname() != null)
            return false;
        if (getTrainer() != null ? !getTrainer().equals(sparrer.getTrainer()) : sparrer.getTrainer() != null)
            return false;
        if (getFirstTrainer() != null ? !getFirstTrainer().equals(sparrer.getFirstTrainer()) : sparrer.getFirstTrainer() != null)
            return false;
        if (getKup() != null ? !getKup().equals(sparrer.getKup()) : sparrer.getKup() != null) return false;
        if (getSex() != null ? !getSex().equals(sparrer.getSex()) : sparrer.getSex() != null) return false;
        if (getBirthday() != null ? !getBirthday().equals(sparrer.getBirthday()) : sparrer.getBirthday() != null)
            return false;
        if (getWeight() != null ? !getWeight().equals(sparrer.getWeight()) : sparrer.getWeight() != null) return false;
        if (getDisciplines() != null ? !getDisciplines().equals(sparrer.getDisciplines()) : sparrer.getDisciplines() != null)
            return false;
        if (getTournament() != null ? !getTournament().equals(sparrer.getTournament()) : sparrer.getTournament() != null)
            return false;
        if (getWeightCategory() != null ? !getWeightCategory().equals(sparrer.getWeightCategory()) : sparrer.getWeightCategory() != null)
            return false;
        return getEvents() != null ? getEvents().equals(sparrer.getEvents()) : sparrer.getEvents() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getTrainer() != null ? getTrainer().hashCode() : 0);
        result = 31 * result + (getFirstTrainer() != null ? getFirstTrainer().hashCode() : 0);
        result = 31 * result + (getKup() != null ? getKup().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getDisciplines() != null ? getDisciplines().hashCode() : 0);
        result = 31 * result + (getTournament() != null ? getTournament().hashCode() : 0);
        result = 31 * result + (getWeightCategory() != null ? getWeightCategory().hashCode() : 0);
        result = 31 * result + (getEvents() != null ? getEvents().hashCode() : 0);
        return result;
    }
}
