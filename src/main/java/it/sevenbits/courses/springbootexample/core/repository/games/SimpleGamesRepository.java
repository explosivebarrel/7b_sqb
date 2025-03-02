package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;

import java.util.*;


public class SimpleGamesRepository implements IGamesRepository {
    private final Map<UUID, Game> gamesMap = new HashMap<>();

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(gamesMap.values());
    }

    @Override
    public Game findById(UUID id) {
        return gamesMap.get(id);
    }

    @Override
    public Game save(Game game) {
        return gamesMap.put(game.getId(), game);
    }
}
