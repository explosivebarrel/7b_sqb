package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.BooksRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.SimpleBooksRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.SimpleGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.SimpleQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.SimpleQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.SimpleRoomsRepository;
import it.sevenbits.courses.springbootexample.core.service.games.GamesService;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questions.QuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.QuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.IRoomsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.RoomsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class with configuration of repository
 */
@Configuration
public class RepositoryConfig {

    /**
     * The method creates instance of books repository
     * @return instance of the books repository
     */
    @Bean
    public BooksRepository booksRepository() {
        return new SimpleBooksRepository();
    }

    @Bean
    public IAnswersRepository answersRepository() {
        return new SimpleAnswersRepository();
    }

    @Bean
    public IGamesRepository gamesRepository() {
        return new SimpleGamesRepository();
    }

    @Bean
    public IRoomsRepository roomsRepository() {
        return new SimpleRoomsRepository();
    }

    @Bean
    public IQuestionsRepository questionsRepository() {
        return new SimpleQuestionsRepository();
    }

    @Bean
    public IQuestionSetsRepository questionSetsRepository() {
        return new SimpleQuestionSetsRepository();
    }
}