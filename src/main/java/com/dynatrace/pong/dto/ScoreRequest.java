package com.dynatrace.pong.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@ValidTableTennisScore
public class ScoreRequest {

    // Also used copilot here to generate boilerplate based on README.

    @NotNull(message = "Player 1 ID is required")
    @Min(value = 1, message = "Player 1 ID must be a valid player ID")
    private Long playerId1;

    @NotNull(message = "Player 2 ID is required")
    @Min(value = 1, message = "Player 2 ID must be a valid player ID")
    private Long playerId2;

    @Min(value = 1, message = "Double player 1 ID must be a valid player ID")
    private Long doublePlayerId1;

    @Min(value = 1, message = "Double player 2 ID must be a valid player ID")
    private Long doublePlayerId2;

    @NotNull(message = "Player 1 points are required")
    @Min(value = 0, message = "Player 1 points must be a number greater than or equal to 0")
    private Integer player1Points;

    @NotNull(message = "Player 2 points are required")
    @Min(value = 0, message = "Player 2 points must be a number greater than or equal to 0")
    private Integer player2Points;

    @Min(value = 0, message = "Player 1 games must be a number greater than or equal to 0")
    @Max(value = 5, message = "Player 1 games must not exceed 5")
    private Integer player1Games = 0;

    @Min(value = 0, message = "Player 2 games must be a number greater than or equal to 0")
    @Max(value = 5, message = "Player 2 games must not exceed 5")
    private Integer player2Games = 0;

    @NotNull(message = "Match date is required")
    private LocalDateTime matchDate;

    public ScoreRequest() {
    }

    public ScoreRequest(Long playerId1,
            Long playerId2,
            Long doublePlayerId1,
            Long doublePlayerId2,
            Integer player1Points,
            Integer player2Points,
            Integer player1Games,
            Integer player2Games,
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

    public Long getPlayerId1() {
        return playerId1;
    }

    public void setPlayerId1(Long playerId1) {
        this.playerId1 = playerId1;
    }

    public Long getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId2(Long playerId2) {
        this.playerId2 = playerId2;
    }

    public Long getDoublePlayerId1() {
        return doublePlayerId1;
    }

    public void setDoublePlayerId1(Long doublePlayerId1) {
        this.doublePlayerId1 = doublePlayerId1;
    }

    public Long getDoublePlayerId2() {
        return doublePlayerId2;
    }

    public void setDoublePlayerId2(Long doublePlayerId2) {
        this.doublePlayerId2 = doublePlayerId2;
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
