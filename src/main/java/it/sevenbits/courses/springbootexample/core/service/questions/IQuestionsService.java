package it.sevenbits.courses.springbootexample.core.service.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface IQuestionsService {
    /**
     *
     * @return rt
     */
    List<Question> getAll();

    /**
     *
     * @param category ctg
     * @return rt
     */
    List<Question> findByCategory(final Category category);

    /**
     *
     * @param content ct
     * @return rt
     */
    List<Question> findByText(final String content); //Regex search in general

    /**
     *
     * @param id id
     * @return rt
     */
    Question findById(final UUID id);

    /**
     *
     * @param question qs
     * @return rt
     */
    Question save(final Question question);
}
