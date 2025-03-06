package it.sevenbits.courses.springbootexample.core.service.questionsets;

import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IQuestionSetsService {
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
