package com.alexjoiner.arenagame.domain;

import javax.persistence.*;

@Entity
public class FightEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fightRound;

    @ManyToOne
    @JoinColumn(name = "fight_id")
    private Fight fight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFightRound() {
        return fightRound;
    }

    public void setFightRound(String fightRound) {
        this.fightRound = fightRound;
    }
}
