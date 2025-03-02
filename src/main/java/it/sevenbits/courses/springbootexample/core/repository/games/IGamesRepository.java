package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.List;
import java.util.UUID;

public interface IGamesRepository {
    List<Game> getAll();
    Game findById(UUID id);
    Game save(Game answer);
}
