package it.sevenbits.courses.springbootexample.core.service.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IGamesService {
    /**
     *
     * @return rt
     */
    List<Game> getAll();

    /**
     *
     * @param id id
     * @return rt
     */
    Game findById(final UUID id);

    /**
     *
     * @param game g
     * @return rt
     */
    Game save(final Game game);

    /**
     *
     * @param questionSetId qssid
     * @return rt
     */
    Game startNewGame(final UUID questionSetId);

    /**
     *
     * @param questionId qsid
     * @return rt
     */
    Game startNewGameWOneQuestion(final UUID questionId);
}
