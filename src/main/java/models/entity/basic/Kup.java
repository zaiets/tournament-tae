package models.entity.basic;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "KUP")
public class Kup {
    @Id
    @Column(name = "RATING")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;

    public Kup() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kup)) return false;

        Kup kup = (Kup) o;

        if (getId() != null ? !getId().equals(kup.getId()) : kup.getId() != null) return false;
        return getName() != null ? getName().equals(kup.getName()) : kup.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
