package it.sevenbits.courses.springbootexample.core.repository.questionsets;

import it.sevenbits.courses.springbootexample.core.model.questionsets.ManualQuestionSet;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class JdbcQuestionSetsRepository implements IQuestionSetsRepository {
    private final JdbcOperations jdbcOperations;

    /**
     *
     * @param jdbcOperations jdbcOperations
     */
    public JdbcQuestionSetsRepository(final JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private List<UUID> getQuestionIdsForSet(final UUID setId) {
        String sql = "SELECT questionId FROM questionSetQuestions WHERE questionSetId = ? ORDER BY sortOrder";
        return jdbcOperations.query(sql,
                (rs, rowNum) ->
                        UUID.fromString(rs.getString("questionId")),
                setId.toString()
        );
    }

    @Override
    public List<QuestionSet> getAll() {
        String sql = "SELECT id, name as label, description, createdAt FROM questionSets";
        return jdbcOperations.query(sql, (rs, rowNum) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            return new QuestionSet(id, rs.getString("label"), rs.getString("description")) {
                @Override
                public List<UUID> getQuestionIDs() {
                    return getQuestionIdsForSet(id);
                }
            };
        });
    }

    @Override
    public QuestionSet findById(final UUID id) {
        String sql = "SELECT name as label, description FROM questionSets WHERE id = ?";
        return jdbcOperations.queryForObject(sql,
            (rs, rowNum) ->
                new ManualQuestionSet(id,
                    rs.getString("label"),
                    rs.getString("description"),
                    getQuestionIdsForSet(id)
                ),
            id.toString()
        );
    }

    @Override
    public QuestionSet save(final QuestionSet questionSet) {
        // Сохраняем сам набор
        String sqlSet = "INSERT INTO questionSets (id, name, description) VALUES (?, ?, ?)";
        jdbcOperations.update(sqlSet,
                questionSet.getId().toString(),
                questionSet.getLabel(),
                questionSet.getDescription()
        );

        // Сохраняем связи с вопросами
        String sqlLinks = "INSERT INTO questionSetQuestions (questionSetId, questionId, sortOrder) VALUES (?, ?, ?)";
        List<UUID> questions = questionSet.getQuestionIDs();
        for (int i = 0; i < questions.size(); i++) {
            jdbcOperations.update(sqlLinks,
                questionSet.getId().toString(),
                questions.get(i).toString(),
                i
            );
        }

        return questionSet;
    }
}