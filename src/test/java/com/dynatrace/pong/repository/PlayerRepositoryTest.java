package com.dynatrace.pong.repository;

import com.dynatrace.pong.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void save_shouldPersistPlayer() {
        Player player = new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1);

        Player saved = playerRepository.save(player);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFirstName()).isEqualTo("Novak");
    }

    @Test
    void findById_shouldReturnPlayer() {
        Player player = playerRepository.save(new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1));

        Optional<Player> found = playerRepository.findById(player.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("novak@tennis.com");
    }

    @Test
    void findByEmail_shouldReturnPlayer() {
        playerRepository.save(new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1));

        Optional<Player> found = playerRepository.findByEmail("novak@tennis.com");

        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("Novak");
    }

    @Test
    void existsByEmail_shouldReturnTrue() {
        playerRepository.save(new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1));

        assertThat(playerRepository.existsByEmail("novak@tennis.com")).isTrue();
    }

    @Test
    void existsByEmail_shouldReturnFalse() {
        assertThat(playerRepository.existsByEmail("nonexistent@tennis.com")).isFalse();
    }

    @Test
    void deleteById_shouldRemovePlayer() {
        Player player = playerRepository.save(new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1));

        playerRepository.deleteById(player.getId());

        assertThat(playerRepository.findById(player.getId())).isEmpty();
    }

    @Test
    void findAll_shouldReturnAllPlayers() {
        playerRepository.save(new Player("Novak", "Djokovic", "novak@tennis.com", "Serbia", 1));
        playerRepository.save(new Player("Rafael", "Nadal", "rafa@tennis.com", "Spain", 2));

        assertThat(playerRepository.findAll()).hasSize(2);
    }
}

