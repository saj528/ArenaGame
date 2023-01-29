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

    private List<String> fightEvents = new ArrayList<>();

    @ManyToMany(mappedBy = "fights")
    private List<Fighter> fighters = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getFightEvents() {
        return fightEvents;
    }

    public void setFightEvents(List<String> fightEvents) {
        this.fightEvents = fightEvents;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }
}
