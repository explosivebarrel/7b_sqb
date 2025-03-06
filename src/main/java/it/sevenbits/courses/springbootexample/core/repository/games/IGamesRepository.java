package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IGamesRepository {
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
     * @param game gm
     * @return rt
     */
    Game save(final Game game);
}
