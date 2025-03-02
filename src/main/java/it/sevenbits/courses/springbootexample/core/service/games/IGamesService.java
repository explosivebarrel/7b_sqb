package it.sevenbits.courses.springbootexample.core.service.games;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.List;
import java.util.UUID;

public interface IGamesService {
    List<Game> getAll();
    Game findById(UUID id);
    Game save(Game game);
    Game startNewGame(UUID questionSetId);
    Game startNewGameWOneQuestion(UUID questionId);
}
