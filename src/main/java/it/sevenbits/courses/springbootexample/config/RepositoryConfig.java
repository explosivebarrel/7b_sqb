package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.PostgresDBAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.PostgresDBGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.PostgresDBQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.PostgresDBQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.PostgresDBRoomsRepository;
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
        return new PostgresDBAnswersRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IRoomsRepository roomsRepository(@Qualifier("squizzesJdbcOperations")
                                            final JdbcOperations jdbcOperations) {
        return new PostgresDBRoomsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IQuestionsRepository questionsRepository(@Qualifier("squizzesJdbcOperations")
                                                    final JdbcOperations jdbcOperations) {
        return new PostgresDBQuestionsRepository(jdbcOperations);
    }

    /**
     * The method creates instance of repository
     * @param jdbcOperations jdbc operations instance
     * @return instance of the repository
     */
    @Bean
    public IQuestionSetsRepository questionSetsRepository(@Qualifier("squizzesJdbcOperations")
                                                          final JdbcOperations jdbcOperations) {
        return new PostgresDBQuestionSetsRepository(jdbcOperations);
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
        return new PostgresDBGamesRepository(questionSetsRepository, jdbcOperations);
    }
}