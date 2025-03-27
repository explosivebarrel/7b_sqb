package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.JdbcGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.SimpleGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.JdbcQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.SimpleQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.SimpleQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.SimpleRoomsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public IRoomsRepository roomsRepository() {
        return new SimpleRoomsRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IQuestionsRepository questionsRepository(@Qualifier("squizzesJdbcOperations")
                                                    JdbcOperations jdbcOperations) {
        return new JdbcQuestionsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IQuestionSetsRepository questionSetsRepository() {
        return new SimpleQuestionSetsRepository();
    }

    /**
     * The method creates instance of repository
     * @return instance of the repository
     */
    @Bean
    public IGamesRepository gamesRepository(IQuestionSetsRepository questionSetsRepository,
                                            @Qualifier("squizzesJdbcOperations")
                                            JdbcOperations jdbcOperations
    ) {
        return new JdbcGamesRepository(questionSetsRepository, jdbcOperations);
    }
}