package it.sevenbits.courses.springbootexample.core.service.games;


import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;

import java.util.List;
import java.util.UUID;

public class GamesService implements IGamesService {
    private final IGamesRepository gamesRepository;
    private final IQuestionSetsService questionSetsService;

    public GamesService(IGamesRepository gamesRepository, IQuestionSetsService questionSetsService) {
        this.gamesRepository = gamesRepository;
        this.questionSetsService = questionSetsService;
    }

    @Override
    public List<Game> getAll() {
        return gamesRepository.getAll();
    }

    @Override
    public Game findById(UUID id) {
        return gamesRepository.findById(id);
    }

    @Override
    public Game save(Game game) {
        return gamesRepository.save(game);
    }

    @Override
    public Game startNewGame(UUID questionSetId) {
        Game newGame = new Game(UUID.randomUUID(), questionSetsService.findById(questionSetId));
        save(newGame);
        return newGame;
    }

    @Override
    public Game startNewGameWOneQuestion(UUID questionId) {
        return null;
    }
}
