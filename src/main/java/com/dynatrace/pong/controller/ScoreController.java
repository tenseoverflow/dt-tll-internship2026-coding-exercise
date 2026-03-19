package com.dynatrace.pong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<ScoreResponse> getScoreById(@PathVariable Long id) {
        return ResponseEntity.ok(scoreService.getScoreById(id));
    }

    @GetMapping
    public ResponseEntity<List<ScoreResponse>> getAllScores() {
        return ResponseEntity.ok(scoreService.getAllScores());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
