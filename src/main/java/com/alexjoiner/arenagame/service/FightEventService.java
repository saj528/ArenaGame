package com.alexjoiner.arenagame.service;

import com.alexjoiner.arenagame.domain.FightEvent;
import com.alexjoiner.arenagame.repository.FightEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FightEventService {

    @Autowired
    private FightEventRepository fightEventRepository;

    public List<FightEvent> findAll() {
        return fightEventRepository.findAll();
    }

    public FightEvent save(FightEvent fightEvent) {

        return fightEventRepository.save(fightEvent);
    }

    public FightEvent findById(Long fightEventId) {
        return fightEventRepository.findById(fightEventId).get();
    }

    public void delete(Long fightEventId) {
        FightEvent fightEvent = fightEventRepository.findById(fightEventId).get();
        fightEventRepository.delete(fightEvent);
    }

}
