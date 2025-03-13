package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.SimpleGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.SimpleQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.SimpleQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.SimpleRoomsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class with configuration of repository
 */
@Configuration
public class RepositoryConfig {

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IAnswersRepository answersRepository() {
        return new SimpleAnswersRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IGamesRepository gamesRepository() {
        return new SimpleGamesRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IRoomsRepository roomsRepository() {
        return new SimpleRoomsRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IQuestionsRepository questionsRepository() {
        return new SimpleQuestionsRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IQuestionSetsRepository questionSetsRepository() {
        return new SimpleQuestionSetsRepository();
    }
}