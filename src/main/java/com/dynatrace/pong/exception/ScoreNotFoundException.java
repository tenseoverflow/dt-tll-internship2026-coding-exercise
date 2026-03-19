package com.dynatrace.pong.exception;

public class ScoreNotFoundException extends RuntimeException {

    public ScoreNotFoundException(Long matchId) {
        super("Score not found with matchId: " + matchId);
    }
}
