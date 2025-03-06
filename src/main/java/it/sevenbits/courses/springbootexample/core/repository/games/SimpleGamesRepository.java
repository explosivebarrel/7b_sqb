package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class SimpleGamesRepository implements IGamesRepository {
    private final Map<UUID, Game> gamesMap = new HashMap<>();

    /**
     *
     * @return rt
     */
    @Override
    public List<Game> getAll() {
        return new ArrayList<>(gamesMap.values());
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Game findById(final UUID id) {
        return gamesMap.get(id);
    }

    /**
     *
     * @param game gm
     * @return rt
     */
    @Override
    public Game save(final Game game) {
        return gamesMap.put(game.getId(), game);
    }
}
