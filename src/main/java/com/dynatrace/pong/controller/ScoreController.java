package com.dynatrace.pong.controller;

import com.dynatrace.pong.dto.ScoreRequest;
import com.dynatrace.pong.dto.ScoreResponse;
import com.dynatrace.pong.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<ScoreResponse> createScore(@Valid @RequestBody ScoreRequest request) {
        ScoreResponse response = scoreService.createScore(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<ScoreResponse> getScoreById(@PathVariable Long matchId) {
        return ResponseEntity.ok(scoreService.getScoreById(matchId));
    }

    @GetMapping
    public ResponseEntity<List<ScoreResponse>> getAllScores() {
        return ResponseEntity.ok(scoreService.getAllScores());
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long matchId) {
        scoreService.deleteScore(matchId);
        return ResponseEntity.noContent().build();
    }

    // This was handled by copilot, based on README
    @PutMapping("/{matchId}")
    public ResponseEntity<ScoreResponse> updateScore(
            @PathVariable Long matchId,
            @Valid @RequestBody ScoreRequest request) {
        ScoreResponse response = scoreService.updateScore(matchId, request);
        return ResponseEntity.ok(response);
    }
}
