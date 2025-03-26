package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcOperations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JdbcGamesRepositoryTest {
    private JdbcOperations mockJdbcOperations;
    private IQuestionSetsRepository mockQuestionSetsRepository;
    private JdbcGamesRepository jdbcGamesRepository;

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