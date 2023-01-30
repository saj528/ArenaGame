package com.alexjoiner.arenagame.repository;

import com.alexjoiner.arenagame.domain.FightEvent;
import com.alexjoiner.arenagame.domain.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightEventRepository extends JpaRepository<FightEvent, Long> {
}
