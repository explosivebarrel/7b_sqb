package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcOperations;

import static org.mockito.Mockito.mock;

class PostgresDBGamesRepositoryTest {
    private JdbcOperations mockJdbcOperations;
    private IQuestionSetsRepository mockQuestionSetsRepository;
    private PostgresDBGamesRepository postgresDBGamesRepository;

    @BeforeEach
    public void init() {
        mockJdbcOperations = mock(JdbcOperations.class);
        mockQuestionSetsRepository = mock(IQuestionSetsRepository.class);
    }

    @Test
    void getAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }
}