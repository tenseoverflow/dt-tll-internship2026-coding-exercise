package com.dynatrace.pong.service;

import com.dynatrace.pong.dto.ScoreRequest;
import com.dynatrace.pong.dto.ScoreResponse;
import com.dynatrace.pong.exception.ScoreNotFoundException;
import com.dynatrace.pong.exception.PlayerNotFoundException;
import com.dynatrace.pong.model.Score;
import com.dynatrace.pong.model.Player;
import com.dynatrace.pong.repository.ScoreRepository;
import com.dynatrace.pong.repository.PlayerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final PlayerRepository playerRepository;

    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository) {
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
    }

    // Used some copilot help here to create a score
    public ScoreResponse createScore(ScoreRequest request) {
        Player player1 = playerRepository.findById(request.getPlayerId1())
                .orElseThrow(() -> new PlayerNotFoundException(request.getPlayerId1()));
        Player player2 = playerRepository.findById(request.getPlayerId2())
                .orElseThrow(() -> new PlayerNotFoundException(request.getPlayerId2()));

        Player doublePlayer1 = null;
        if (request.getDoublePlayerId1() != null) {
            doublePlayer1 = playerRepository.findById(request.getDoublePlayerId1())
                    .orElseThrow(() -> new PlayerNotFoundException(request.getDoublePlayerId1()));
        }

        Player doublePlayer2 = null;
        if (request.getDoublePlayerId2() != null) {
            doublePlayer2 = playerRepository.findById(request.getDoublePlayerId2())
                    .orElseThrow(() -> new PlayerNotFoundException(request.getDoublePlayerId2()));
        }

        Score score = new Score(
                player1,
                player2,
                doublePlayer1,
                doublePlayer2,
                request.getPlayer1Points(),
                request.getPlayer2Points(),
                request.getPlayer1Games(),
                request.getPlayer2Games(),
                request.getMatchDate());

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
    // Copilot used here to create updateScore method

    public ScoreResponse updateScore(Long matchId, ScoreRequest request) {
        Score score = scoreRepository.findById(matchId)
                .orElseThrow(() -> new ScoreNotFoundException(matchId));

        Player player1 = playerRepository.findById(request.getPlayerId1())
                .orElseThrow(() -> new PlayerNotFoundException(request.getPlayerId1()));
        Player player2 = playerRepository.findById(request.getPlayerId2())
                .orElseThrow(() -> new PlayerNotFoundException(request.getPlayerId2()));

        Player doublePlayer1 = null;
        if (request.getDoublePlayerId1() != null) {
            doublePlayer1 = playerRepository.findById(request.getDoublePlayerId1())
                    .orElseThrow(() -> new PlayerNotFoundException(request.getDoublePlayerId1()));
        }

        Player doublePlayer2 = null;
        if (request.getDoublePlayerId2() != null) {
            doublePlayer2 = playerRepository.findById(request.getDoublePlayerId2())
                    .orElseThrow(() -> new PlayerNotFoundException(request.getDoublePlayerId2()));
        }

        score.setPlayer1(player1);
        score.setPlayer2(player2);
        score.setDoublePlayer1(doublePlayer1);
        score.setDoublePlayer2(doublePlayer2);
        score.setPlayer1Points(request.getPlayer1Points());
        score.setPlayer2Points(request.getPlayer2Points());
        score.setPlayer1Games(request.getPlayer1Games());
        score.setPlayer2Games(request.getPlayer2Games());
        score.setMatchDate(request.getMatchDate());

        Score updated = scoreRepository.save(score);
        return toResponse(updated);
    }

    private ScoreResponse toResponse(Score score) {
        return new ScoreResponse(
                score.getMatchId(),
                score.getPlayer1().getId(),
                score.getPlayer2().getId(),
                score.getDoublePlayer1() != null ? score.getDoublePlayer1().getId() : null,
                score.getDoublePlayer2() != null ? score.getDoublePlayer2().getId() : null,
                score.getPlayer1Points(),
                score.getPlayer2Points(),
                score.getPlayer1Games(),
                score.getPlayer2Games(),
                score.getMatchDate());
    }
}
