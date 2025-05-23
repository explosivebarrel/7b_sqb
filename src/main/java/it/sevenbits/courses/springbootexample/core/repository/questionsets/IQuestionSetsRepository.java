package it.sevenbits.courses.springbootexample.core.repository.questionsets;

import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Repository
public interface IQuestionSetsRepository {
    /**
     *
     * @return rt
     */
    List<QuestionSet> getAll();

    /**
     *
     * @param id id
     * @return rt
     */
    QuestionSet findById(final UUID id);

    /**
     *
     * @param question qs
     * @return rt
     */
    QuestionSet save(final QuestionSet question);
}
