package com.alexjoiner.arenagame.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Fighter")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private Integer hp;
    private Integer level;
    private Integer xp;
    private Integer attack_damage;
    private Boolean alive;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "challenger", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Fight> challengerFights = new ArrayList<>();

    @OneToMany(mappedBy = "defender", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Fight> defenderFights = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(Integer attack_damage) {
        this.attack_damage = attack_damage;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Fight> getChallengerFights() {
        return challengerFights;
    }

    public void setChallengerFights(List<Fight> challengerFights) {
        this.challengerFights = challengerFights;
    }

    public List<Fight> getDefenderFights() {
        return defenderFights;
    }

    public void setDefenderFights(List<Fight> defenderFights) {
        this.defenderFights = defenderFights;
    }
}
