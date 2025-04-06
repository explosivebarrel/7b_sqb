package it.sevenbits.courses.springbootexample.core.repository.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Repository
public class PostgresDBAnswersRepository implements IAnswersRepository {
    private final JdbcOperations jdbcOperations;

    /**
     *
     * @param jdbcOperations jdbcOperations
     */
    public PostgresDBAnswersRepository(final JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Answer> getAll() {
        String sql = "SELECT id, content as answerText FROM answers";
        return jdbcOperations.query(sql, (rs, rowNum) ->
                new Answer(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("answerText")
                )
        );
    }

    @Override
    public Answer findById(final UUID id) {
        String sql = "SELECT content as answerText FROM answers WHERE id = ?";
        return jdbcOperations.queryForObject(sql,
                (rs, rowNum) -> new Answer(id, rs.getString("answerText")),
                id.toString()
        );
    }

    @Override
    public Answer save(final Answer answer) {
        String sql = "INSERT INTO answers (id, content) VALUES (?, ?)";
        jdbcOperations.update(sql,
                answer.getId().toString(),
                answer.getText()
        );
        return answer;
    }
}