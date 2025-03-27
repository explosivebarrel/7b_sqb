package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.model.games.GameStatus;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JdbcGamesRepository implements IGamesRepository {
    private final IQuestionSetsRepository questionSetRepo;
    private final JdbcOperations jdbcOperations;

    public JdbcGamesRepository(IQuestionSetsRepository questionSetRepo, JdbcOperations jdbcOperations) {
        this.questionSetRepo = questionSetRepo;
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Game> getAll() {
        String sql = "SELECT id, questionsetid FROM games";
        return jdbcOperations.query(sql, (rs, rowNum) ->
                new Game(
                        UUID.fromString(rs.getString("id")),
                        questionSetRepo.findById(UUID.fromString(rs.getString("questionsetid")))
                )
        );
    }

    @Override
    public Game findById(UUID id) {
        String sql = "SELECT id, questionsetid FROM games WHERE id = ?";
        return jdbcOperations.queryForObject(sql,
            (rs, rowNum) -> new Game(
                UUID.fromString(rs.getString("id")),
                questionSetRepo.findById(UUID.fromString(rs.getString("questionsetid")))
            ),
            id.toString()
        );
    }

    @Override
    public Game save(Game game) {
        String sql = "INSERT INTO games (id, questionsetid, status) VALUES (?, ?, ?)";
        jdbcOperations.update(sql,
            game.getId().toString(),
            game.getQuestions().getId().toString(),
            GameStatus.READY_TO_START.getName()
        );
        return game;
    }
}