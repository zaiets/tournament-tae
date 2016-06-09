package models.entity.competition;


import models.entity.basic.Kup;
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
@Table(name = "SPARRERS")
public class Sparrer {
    @Id
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
    @ManyToOne
    @JoinColumn(name = "KUP_ID")
    private Kup kup;
    @Basic
    @Column(name = "NAME")
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


}
