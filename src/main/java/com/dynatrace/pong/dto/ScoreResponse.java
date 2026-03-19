package com.dynatrace.pong.dto;

import java.time.LocalDateTime;

public class ScoreResponse {

    // Used Copilot to generate this response based on README
    private Long matchId;
    private Long playerId1;
    private Long playerId2;
    private Long doublePlayerId1;
    private Long doublePlayerId2;
    private Integer player1Points;
    private Integer player2Points;
    private Integer player1Games;
    private Integer player2Games;
    private LocalDateTime matchDate;

    public ScoreResponse() {
    }

    public ScoreResponse(Long matchId,
            Long playerId1,
            Long playerId2,
            Long doublePlayerId1,
            Long doublePlayerId2,
            Integer player1Points,
            Integer player2Points,
            Integer player1Games,
            Integer player2Games,
            LocalDateTime matchDate) {
        this.matchId = matchId;
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

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
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
