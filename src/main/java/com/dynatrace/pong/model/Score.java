package com.dynatrace.pong.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @Column(nullable = false)
    private Long playerId1;

    @Column(nullable = false)
    private Long playerId2;

    private Long doublePlayerId1;

    private Long doublePlayerId2;

    @Column(nullable = false)
    private Integer player1Points;

    @Column(nullable = false)
    private Integer player2Points;

    @Column(nullable = false)
    private Integer player1Games;

    @Column(nullable = false)
    private Integer player2Games;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    public Score() {
    }

    public Score(Long playerId1, Long playerId2, Long doublePlayerId1, Long doublePlayerId2,
            Integer player1Points, Integer player2Points, Integer player1Games, Integer player2Games,
            LocalDateTime matchDate) {
        this.playerId1 = playerId1;
        this.playerId2 = playerId2;
        this.doublePlayerId1 = doublePlayerId1;
        this.doublePlayerId2 = doublePlayerId2;
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.player1Games = player1Games;
        this.player2Games = player2Games;
        this.matchDate = matchDate;
    }

}
