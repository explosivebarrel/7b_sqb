package it.sevenbits.courses.springbootexample.core.repository.questionsets;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.*;

public class SimpleQuestionSetsRepository implements IQuestionSetsRepository {
    private final Map<UUID, QuestionSet> questionSetMap = new HashMap<>();

    @Override
    public List<QuestionSet> getAll() {
        return new ArrayList<>(questionSetMap.values());
    }

    @Override
    public QuestionSet findById(UUID id) {
        return questionSetMap.get(id);
    }

    @Override
    public QuestionSet save(QuestionSet question) {
        return questionSetMap.put(question.getId(), question);
    }
}
