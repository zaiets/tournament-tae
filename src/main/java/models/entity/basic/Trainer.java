package models.entity.basic;


import models.entity.competition.Sparrer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "TRAINERS")
public class Trainer {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PATRONYMIC")
    private String patronymic;
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;
    @OneToMany(mappedBy = "SPARRERS")
    private Set<Sparrer> sparrers;

    public Trainer () {    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
        return getSchool() != null ? getSchool().equals(trainer.getSchool()) : trainer.getSchool() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        result = 31 * result + (getSchool() != null ? getSchool().hashCode() : 0);
        return result;
    }
}
