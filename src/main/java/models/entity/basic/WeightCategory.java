package models.entity.basic;


import models.entity.competition.Sparrer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Entity
@Table(name = "WEIGHT_CATEGORIES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NAME"),
                @UniqueConstraint(columnNames = "WEIGHT_FACTOR")})
public class WeightCategory {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "SEX", nullable=false)
    private Character sex;
    @Basic
    @Column(name = "MIN_AGE", nullable=false)
    private Integer minAge;
    @Basic
    @Column(name = "MAX_AGE", nullable=false)
    private Integer maxAge;
    @Basic
    @Column(name = "MIN_WEIGHT", nullable=false)
    private Integer minWeight;
    @Basic
    @Column(name = "MAX_WEIGHT", nullable=false)
    private Integer maxWeight;
    @Basic
    @Column(name = "NAME", nullable=false)
    private String name;
    @Basic
    @Column(name = "WEIGHT_FACTOR", nullable=false)
    private String weightFactor;
    @OneToMany(mappedBy = "weightCategory")
    private Set<Sparrer> sparrers;

    public WeightCategory() {    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(String weightFactor) {
        this.weightFactor = weightFactor;
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
        if (!(o instanceof WeightCategory)) return false;

        WeightCategory that = (WeightCategory) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null) return false;
        if (getMinAge() != null ? !getMinAge().equals(that.getMinAge()) : that.getMinAge() != null) return false;
        if (getMaxAge() != null ? !getMaxAge().equals(that.getMaxAge()) : that.getMaxAge() != null) return false;
        if (getMinWeight() != null ? !getMinWeight().equals(that.getMinWeight()) : that.getMinWeight() != null)
            return false;
        if (getMaxWeight() != null ? !getMaxWeight().equals(that.getMaxWeight()) : that.getMaxWeight() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getWeightFactor() != null ? !getWeightFactor().equals(that.getWeightFactor()) : that.getWeightFactor() != null)
            return false;
        return getSparrers() != null ? getSparrers().equals(that.getSparrers()) : that.getSparrers() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getMinAge() != null ? getMinAge().hashCode() : 0);
        result = 31 * result + (getMaxAge() != null ? getMaxAge().hashCode() : 0);
        result = 31 * result + (getMinWeight() != null ? getMinWeight().hashCode() : 0);
        result = 31 * result + (getMaxWeight() != null ? getMaxWeight().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getWeightFactor() != null ? getWeightFactor().hashCode() : 0);
        result = 31 * result + (getSparrers() != null ? getSparrers().hashCode() : 0);
        return result;
    }
}
