package it.sevenbits.courses.springbootexample.core.service.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IAnswersService {
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
    Answer findById(final UUID id);

    /**
     *
     * @param answer a
     * @return rt
     */
    Answer save(final Answer answer);
}
