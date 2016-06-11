package models.entity.basic;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "SCHOOLS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NAME")})
public class School {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "school")
    private Set<Trainer> trainers;

    public School() {
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

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;

        School school = (School) o;

        if (getId() != null ? !getId().equals(school.getId()) : school.getId() != null) return false;
        if (getName() != null ? !getName().equals(school.getName()) : school.getName() != null) return false;
        return getTrainers() != null ? getTrainers().equals(school.getTrainers()) : school.getTrainers() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getTrainers() != null ? getTrainers().hashCode() : 0);
        return result;
    }
}
