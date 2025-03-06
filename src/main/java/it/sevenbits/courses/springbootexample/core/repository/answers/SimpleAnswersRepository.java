package it.sevenbits.courses.springbootexample.core.repository.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

/**
 *
 */
public class SimpleAnswersRepository implements IAnswersRepository {
    private final Map<UUID, Answer> answerMap = new HashMap<>();

    /**
     *
     * @return rt
     */
    @Override
    public List<Answer> getAll() {
        return new ArrayList<>(answerMap.values());
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Answer findById(final UUID id) {
        return answerMap.get(id);
    }

    /**
     *
     * @param answer a
     * @return rt
     */
    @Override
    public Answer save(final Answer answer) {
        return answerMap.put(answer.getId(), answer);
    }
}
