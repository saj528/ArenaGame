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

    @ManyToOne
    private Fighter challenger = new Fighter();

    @ManyToOne
    private Fighter defender = new Fighter();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fighter getChallenger() {
        return challenger;
    }

    public void setChallenger(Fighter challenger) {
        this.challenger = challenger;
    }

    public Fighter getDefender() {
        return defender;
    }

    public void setDefender(Fighter defender) {
        this.defender = defender;
    }
}
