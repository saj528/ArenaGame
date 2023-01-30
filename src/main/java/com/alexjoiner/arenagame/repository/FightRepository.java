package com.alexjoiner.arenagame.repository;

import com.alexjoiner.arenagame.domain.Fight;
import com.alexjoiner.arenagame.domain.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Fight, Long> {
}
