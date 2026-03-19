package com.dynatrace.pong.service;

import com.dynatrace.pong.dto.PlayerRequest;
import com.dynatrace.pong.dto.PlayerResponse;
import com.dynatrace.pong.dto.ScoreRequest;
import com.dynatrace.pong.dto.ScoreResponse;
import com.dynatrace.pong.exception.DuplicateEmailException;
import com.dynatrace.pong.exception.PlayerNotFoundException;
import com.dynatrace.pong.exception.ScoreNotFoundException;
import com.dynatrace.pong.model.Player;
import com.dynatrace.pong.model.Score;
import com.dynatrace.pong.repository.PlayerRepository;
import com.dynatrace.pong.repository.ScoreRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public ScoreResponse createScore(ScoreRequest request) {
        Score score = new Score(

        );

        Score saved = scoreRepository.save(score);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public ScoreResponse getScoreById(Long id) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new ScoreNotFoundException(id));
        return toResponse(score);
    }

    @Transactional(readOnly = true)
    public List<ScoreResponse> getAllScores() {
        return scoreRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public void deleteScore(Long matchId) {
        if (!scoreRepository.existsById(matchId)) {
            throw new ScoreNotFoundException(matchId);
        }
        scoreRepository.deleteById(matchId);
    }

    private ScoreResponse toResponse(Score score) {
        return new ScoreResponse(
                score.getId(),
                score.getPlayerId1(),
                score.getPlayerId2(),
                score.getDoublePlayerId1(),
                score.getDoublePlayerId2(),
                score.getPlayer1Points(),
                score.getPlayer2Points(),
                score.getPlayer1Games(),
                score.getPlayer2Games(),
                score.getMatchDate());
    }
}
