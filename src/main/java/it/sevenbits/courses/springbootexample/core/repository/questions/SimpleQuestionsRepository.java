package it.sevenbits.courses.springbootexample.core.repository.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class SimpleQuestionsRepository implements IQuestionsRepository {
    private final Map<UUID, Question> questionMap = new HashMap<>();

    /**
     *
     * @return rt
     */
    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questionMap.values());
    }

    /**
     *
     * @param category ctg
     * @return
     */
    @Override
    public List<Question> findByCategory(final Category category) {
        return null;
    }

    /**
     *
     * @param content ct
     * @return rt
     */
    @Override
    public List<Question> findByText(final String content) {
        return null;
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Question findById(final UUID id) {
        return questionMap.get(id);
    }

    /**
     *
     * @param question qs
     * @return rt
     */
    @Override
    public Question save(final Question question) {
        return questionMap.put(question.getId(), question);
    }
}
