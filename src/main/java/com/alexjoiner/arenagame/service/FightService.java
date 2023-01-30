package com.alexjoiner.arenagame.service;

import com.alexjoiner.arenagame.domain.Fight;
import com.alexjoiner.arenagame.domain.Fighter;
import com.alexjoiner.arenagame.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class FightService {

    @Autowired
    private FightRepository fightRepository;

    Random random = new Random();

    public Fight save(Fight fight) {

        return fightRepository.save(fight);
    }

    public Fight findById(Long fightId) {
        return fightRepository.findById(fightId).get();
    }

    public void processFight(Fight fight) {
/*        int rounds = 3;
        Fighter fighterOne = CloneFighter(fight.getFighters().get(0));
        Fighter fighterTwo = CloneFighter(fight.getFighters().get(1));
        for(int i = 0; i < rounds;i++){
            int damageModifier = random.nextInt((4 - (-2)) + (-2));
            fighterOne.setHp(fighterTwo.getAttack_damage() + damageModifier);
            fighterTwo.setHp(fighterOne.getAttack_damage() + damageModifier);

            FightEvent fightEventOne = new FightEvent();
            fightEventOne.setFightRound(fighterOne.getName() + " attacks " + fighterTwo.getName() + " for " + (fighterOne.getAttack_damage() + damageModifier) + "damage leaving him with " + fighterOne.getHp() + "hp.");

            FightEvent fightEventTwo = new FightEvent();
            fightEventTwo.setFightRound(fighterTwo.getName() + " attacks " + fighterOne.getName() + " for " + (fighterTwo.getAttack_damage() + damageModifier) + "damage leaving him with " + fighterTwo.getHp() + "hp.");

            fight.getFightEvents().add(fightEventOne);
            fight.getFightEvents().add(fightEventTwo);
        }*/
    }

    public Fighter CloneFighter(Fighter fighter){
        Fighter fighterClone = new Fighter();

        fighterClone.setName(fighter.getName());
        fighterClone.setHp(fighter.getHp());
        fighterClone.setAttack_damage(fighter.getAttack_damage());

        return fighterClone;
    }

}
