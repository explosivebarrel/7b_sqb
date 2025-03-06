package it.sevenbits.courses.springbootexample.core.repository.questionsets;

import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.*;

/**
 *
 */
public class SimpleQuestionSetsRepository implements IQuestionSetsRepository {
    private final Map<UUID, QuestionSet> questionSetMap = new HashMap<>();

    /**
     *
     * @return rt
     */
    @Override
    public List<QuestionSet> getAll() {
        return new ArrayList<>(questionSetMap.values());
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public QuestionSet findById(final UUID id) {
        return questionSetMap.get(id);
    }

    /**
     *
     * @param question qs
     * @return rt
     */
    @Override
    public QuestionSet save(final QuestionSet question) {
        return questionSetMap.put(question.getId(), question);
    }
}
