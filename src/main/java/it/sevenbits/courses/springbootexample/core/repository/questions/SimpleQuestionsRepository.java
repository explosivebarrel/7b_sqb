package it.sevenbits.courses.springbootexample.core.repository.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;

import java.util.*;

public class SimpleQuestionsRepository implements IQuestionsRepository {
    private final Map<UUID, Question> questionMap = new HashMap<>();

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questionMap.values());
    }

    @Override
    public List<Question> findByCategory(Category category) {
        return null;
    }

    @Override
    public List<Question> findByText(String content) {
        return null;
    }

    @Override
    public Question findById(UUID id) {
        return questionMap.get(id);
    }

    @Override
    public Question save(Question question) {
        return questionMap.put(question.getId(), question);
    }
}
