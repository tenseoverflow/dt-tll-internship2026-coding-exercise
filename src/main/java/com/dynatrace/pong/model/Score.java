package com.dynatrace.pong.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id_1", nullable = false)
    private Player player1;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id_2", nullable = false)
    private Player player2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "double_player_id_1")
    private Player doublePlayer1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "double_player_id_2")
    private Player doublePlayer2;

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

    public Score(Player player1, Player player2, Player doublePlayer1, Player doublePlayer2,
            Integer player1Points, Integer player2Points, Integer player1Games, Integer player2Games,
            LocalDateTime matchDate) {
        this.player1 = player1;
        this.player2 = player2;
        this.doublePlayer1 = doublePlayer1;
        this.doublePlayer2 = doublePlayer2;
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.player1Games = player1Games;
        this.player2Games = player2Games;
        this.matchDate = matchDate;
    }

    // Used some copilot tab help here for getters and setters
    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getDoublePlayer1() {
        return doublePlayer1;
    }

    public void setDoublePlayer1(Player doublePlayer1) {
        this.doublePlayer1 = doublePlayer1;
    }

    public Player getDoublePlayer2() {
        return doublePlayer2;
    }

    public void setDoublePlayer2(Player doublePlayer2) {
        this.doublePlayer2 = doublePlayer2;
    }

    public Integer getPlayer1Points() {
        return player1Points;
    }

    public void setPlayer1Points(Integer player1Points) {
        this.player1Points = player1Points;
    }

    public Integer getPlayer2Points() {
        return player2Points;
    }

    public void setPlayer2Points(Integer player2Points) {
        this.player2Points = player2Points;
    }

    public Integer getPlayer1Games() {
        return player1Games;
    }

    public void setPlayer1Games(Integer player1Games) {
        this.player1Games = player1Games;
    }

    public Integer getPlayer2Games() {
        return player2Games;
    }

    public void setPlayer2Games(Integer player2Games) {
        this.player2Games = player2Games;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

}
