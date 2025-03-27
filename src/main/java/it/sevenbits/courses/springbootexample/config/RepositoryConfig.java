package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.JdbcAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.JdbcGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.JdbcQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.JdbcQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.JdbcRoomsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Class with configuration of repository
 */
@Configuration
public class RepositoryConfig {

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IAnswersRepository answersRepository(@Qualifier("squizzesJdbcOperations")
                                                final JdbcOperations jdbcOperations) {
        return new JdbcAnswersRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IRoomsRepository roomsRepository(@Qualifier("squizzesJdbcOperations")
                                            final JdbcOperations jdbcOperations) {
        return new JdbcRoomsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IQuestionsRepository questionsRepository(@Qualifier("squizzesJdbcOperations")
                                                    final JdbcOperations jdbcOperations) {
        return new JdbcQuestionsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IQuestionSetsRepository questionSetsRepository(@Qualifier("squizzesJdbcOperations")
                                                          final JdbcOperations jdbcOperations) {
        return new JdbcQuestionSetsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param questionSetsRepository instance of the repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IGamesRepository gamesRepository(final IQuestionSetsRepository questionSetsRepository,
                                            @Qualifier("squizzesJdbcOperations")
                                            final JdbcOperations jdbcOperations
    ) {
        return new JdbcGamesRepository(questionSetsRepository, jdbcOperations);
    }
}