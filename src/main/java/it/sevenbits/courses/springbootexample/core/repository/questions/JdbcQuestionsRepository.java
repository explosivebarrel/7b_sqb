package it.sevenbits.courses.springbootexample.core.repository.questions;
import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import org.flywaydb.core.internal.util.Pair;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Repository
public class JdbcQuestionsRepository implements IQuestionsRepository {
    private final JdbcOperations jdbcOperations;

    public JdbcQuestionsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private Question generateQuestionWithItsAnswers(UUID id, String content) {
        String sqlLinkTable = "SELECT answerId, isCorrect FROM questionAnswers WHERE questionId = ?";

        List<Pair<UUID, Boolean>> answers = jdbcOperations.query(sqlLinkTable, (rs, rowNum) -> {
//                System.out.println("Query for answer: " + rs);
                return Pair.of(UUID.fromString(rs.getString("answerId")), Boolean.valueOf(rs.getString("isCorrect")));
            },
            id.toString()
        );

        UUID correctId = new UUID(0,0);
        List<UUID> incorrectIds = new LinkedList<>();
        for(var p: answers) {
            if (p.getRight().equals(true)) {
                correctId = p.getLeft();
            } else {
                incorrectIds.add(p.getLeft());
            }
        }

        return new Question(id, incorrectIds, correctId, content);
    }

    @Override
    public List<Question> getAll() {
        String sqlQuestionsTable = "SELECT id, content FROM questions";

        return jdbcOperations.query(sqlQuestionsTable, (rs, rowNumE) ->
            generateQuestionWithItsAnswers(UUID.fromString(rs.getString("id")), rs.getString("content"))
        );
    }

    @Override
    public List<Question> findByCategory(Category category) {
        return null;
    }

    @Override
    public List<Question> findByText(String content) {
        String sqlQuestionsTable = "SELECT id, content FROM questions WHERE content LIKE ?";

        return jdbcOperations.query(sqlQuestionsTable,
            (rs, rowNumE) ->
                generateQuestionWithItsAnswers(UUID.fromString(rs.getString("id")), rs.getString("content")),
            "%" + content + "%");
    }

    @Override
    public Question findById(UUID id) {
        String sqlQuestionsTable = "SELECT id, content FROM questions WHERE id = ?";

        return jdbcOperations.queryForObject(sqlQuestionsTable,
            (rs, rowNumE) -> {
//                System.out.println("Query for question: " + rs);
                return generateQuestionWithItsAnswers(UUID.fromString(rs.getString("id")), rs.getString("content"));
            },
            id.toString());
    }

    @Override
    public Question save(Question question) {
        String sqlQuestionsTable = "INSERT INTO questions (id, content) VALUES (?, ?)";
        String sqlLinkTable = "INSERT INTO questionAnswers (questionId, answerId, isCorrect) VALUES (?, ?, ?)";

        jdbcOperations.update(sqlQuestionsTable,
                question.getId().toString(),
                question.getText());

        for (var a: question.getAllAnswerIDs()) {
            jdbcOperations.update(sqlLinkTable,
                    question.getId().toString(),
                    a.toString(),
                    a.equals(question.getCorrectAnswerID())
            );
        }

        return question;
    }
}