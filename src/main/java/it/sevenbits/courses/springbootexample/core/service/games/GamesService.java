package it.sevenbits.courses.springbootexample.core.service.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class GamesService implements IGamesService {
    private final IGamesRepository gamesRepository;
    private final IQuestionSetsService questionSetsService;

    /**
     *
     * @param gamesRepository gmr
     * @param questionSetsService qsss
     */
    public GamesService(final IGamesRepository gamesRepository,
                        final IQuestionSetsService questionSetsService) {
        this.gamesRepository = gamesRepository;
        this.questionSetsService = questionSetsService;
    }

    /**
     *
     * @return rt
     */
    @Override
    public List<Game> getAll() {
        return gamesRepository.getAll();
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Game findById(final UUID id) {
        return gamesRepository.findById(id);
    }

    /**
     *
     * @param game g
     * @return rt
     */
    @Override
    public Game save(final Game game) {
        return gamesRepository.save(game);
    }

    /**
     *
     * @param questionSetId qssid
     * @return rt
     */
    @Override
    public Game startNewGame(final UUID questionSetId) {
        Game newGame = new Game(UUID.randomUUID(), questionSetsService.findById(questionSetId));
        save(newGame);
        return newGame;
    }

    /**
     *
     * @param questionId qsid
     * @return rt
     */
    @Override
    public Game startNewGameWOneQuestion(final UUID questionId) {
        return null;
    }
}
