package models.entity.basic;


import models.entity.competition.Sparrer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "TRAINERS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "SURNAME"),
                @UniqueConstraint(columnNames = "NAME"),
                @UniqueConstraint(columnNames = "PATRONYMIC")})
public class Trainer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "SURNAME", nullable=false)
    private String surname;
    @Basic
    @Column(name = "NAME", nullable=false)
    private String name;
    @Basic
    @Column(name = "PATRONYMIC", nullable=false)
    private String patronymic;
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;
    @OneToMany(mappedBy = "trainer")
    private Set<Sparrer> sparrers;

    public Trainer () {    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
        if (!(o instanceof Trainer)) return false;

        Trainer trainer = (Trainer) o;

        if (getId() != null ? !getId().equals(trainer.getId()) : trainer.getId() != null) return false;
        if (getSurname() != null ? !getSurname().equals(trainer.getSurname()) : trainer.getSurname() != null)
            return false;
        if (getName() != null ? !getName().equals(trainer.getName()) : trainer.getName() != null) return false;
        if (getPatronymic() != null ? !getPatronymic().equals(trainer.getPatronymic()) : trainer.getPatronymic() != null)
            return false;
        if (getSchool() != null ? !getSchool().equals(trainer.getSchool()) : trainer.getSchool() != null) return false;
        return getSparrers() != null ? getSparrers().equals(trainer.getSparrers()) : trainer.getSparrers() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        result = 31 * result + (getSchool() != null ? getSchool().hashCode() : 0);
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        return result;
    }
}
