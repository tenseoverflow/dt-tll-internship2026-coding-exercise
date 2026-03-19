package com.dynatrace.pong.repository;

import com.dynatrace.pong.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Player, Long> {

}
