package models.entity.competition;


import models.entity.basic.Tournament;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@Entity
@DiscriminatorValue("1")
public class SparringEvent extends Event {
    //sparring unique fields
    @OneToOne
    @JoinColumn(name = "WINNER_ID")
    private Sparrer winnerOfPair;
    @Basic
    @Column(name = "PHASE")
    private Integer phase;


    public SparringEvent() {
    }

    public Sparrer getWinnerOfPair() {
        return winnerOfPair;
    }

    public void setWinnerOfPair(Sparrer winnerOfPair) {
        this.winnerOfPair = winnerOfPair;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SparringEvent)) return false;

        SparringEvent that = (SparringEvent) o;

        if (getWinnerOfPair() != null ? !getWinnerOfPair().equals(that.getWinnerOfPair()) : that.getWinnerOfPair() != null)
            return false;
        return getPhase() != null ? getPhase().equals(that.getPhase()) : that.getPhase() == null;

    }

    @Override
    public int hashCode() {
        int result = getWinnerOfPair() != null ? getWinnerOfPair().hashCode() : 0;
        result = 31 * result + (getPhase() != null ? getPhase().hashCode() : 0);
        return result;
    }
}
