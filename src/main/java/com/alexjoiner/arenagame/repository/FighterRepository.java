package com.alexjoiner.arenagame.repository;

import com.alexjoiner.arenagame.domain.Fighter;
import com.alexjoiner.arenagame.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
