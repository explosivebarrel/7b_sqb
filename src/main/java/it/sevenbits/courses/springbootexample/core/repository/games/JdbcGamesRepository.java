package it.sevenbits.courses.springbootexample.core.repository.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JdbcGamesRepository implements IGamesRepository {
    private final IQuestionSetsRepository questionSetRepo;
    private final JdbcTemplate jdbcTemplate;

    public JdbcGamesRepository(IQuestionSetsRepository questionSetRepo,
                               JdbcTemplate jdbcTemplate) {
        this.questionSetRepo = questionSetRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> getAll() {
        String sql = "SELECT id, questionSetId FROM games";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Game(
                UUID.fromString(rs.getString("id")),
                questionSetRepo.findById(UUID.fromString(rs.getString("questionSetId")))
            )
        );
    }

    @Override
    public Game findById(UUID id) {
        String sql = "SELECT id, questionSetId FROM games WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
            new Game(
                UUID.fromString(rs.getString("id")),
                questionSetRepo.findById(UUID.fromString(rs.getString("questionSetId")))
            ),
            id.toString()
        );
    }

    @Override
    public Game save(Game game) {
        String sql = "INSERT INTO games (id, questionSetId) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                game.getId().toString(),
                game.getQuestions().getId().toString()
        );
        return game;
    }
}