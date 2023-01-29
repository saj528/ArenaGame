package com.alexjoiner.arenagame.service;

import com.alexjoiner.arenagame.domain.Fighter;
import com.alexjoiner.arenagame.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    Random random = new Random();

    public List<Fighter> findAll() {
        return fighterRepository.findAll();
    }

    public Fighter save(Fighter fighter) {

        fighter.setHp(random.nextInt(15 - 10) + 10);
        fighter.setAttack_damage(random.nextInt(4 - 2) + 2);
        fighter.setLevel(1);
        fighter.setXp(0);
        fighter.setAlive(true);

        return fighterRepository.save(fighter);
    }

    public Fighter findById(Long fighterId) {
        return fighterRepository.findById(fighterId).get();
    }

    public void delete(Long fighterId) {
        Fighter fighter = fighterRepository.findById(fighterId).get();
        fighterRepository.delete(fighter);
    }
}
