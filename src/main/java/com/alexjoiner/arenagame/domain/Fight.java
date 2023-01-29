package com.alexjoiner.arenagame.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fight")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "fight", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<FightEvent> fightEvents = new ArrayList<>();

    @ManyToMany(mappedBy = "fights")
    private List<Fighter> fighters = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FightEvent> getFightEvents() {
        return fightEvents;
    }

    public void setFightEvents(List<FightEvent> fightEvents) {
        this.fightEvents = fightEvents;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }
}
