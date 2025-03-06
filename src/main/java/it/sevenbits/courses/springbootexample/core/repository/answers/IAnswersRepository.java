package it.sevenbits.courses.springbootexample.core.repository.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IAnswersRepository {
    /**
     *
     * @return rt
     */
    List<Answer> getAll();

    /**
     *
     * @param id id
     * @return rt
     */
    Answer findById(UUID id);

    /**
     *
     * @param answer a
     * @return rt
     */
    Answer save(Answer answer);
}
