package it.sevenbits.courses.springbootexample.core.service.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class QuestionsService implements IQuestionsService {
    private final IQuestionsRepository questionsRepository;

    /**
     *
     * @param questionsRepository qr
     */
    public QuestionsService(final IQuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    /**
     *
     * @return rt
     */
    @Override
    public List<Question> getAll() {
        return questionsRepository.getAll();
    }

    /**
     *
     * @param category ctg
     * @return rt
     */
    @Override
    public List<Question> findByCategory(final Category category) {
        return questionsRepository.findByCategory(category);
    }

    /**
     *
     * @param content ct
     * @return rt
     */
    @Override
    public List<Question> findByText(final String content) {
        return questionsRepository.findByText(content);
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Question findById(final UUID id) {
        return questionsRepository.findById(id);
    }

    /**
     *
     * @param question qs
     * @return rt
     */
    @Override
    public Question save(final Question question) {
        return questionsRepository.save(question);
    }
}
