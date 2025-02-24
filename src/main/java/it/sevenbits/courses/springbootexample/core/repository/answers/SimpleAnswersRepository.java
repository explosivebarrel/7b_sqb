package it.sevenbits.courses.springbootexample.core.repository.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.*;


public class SimpleAnswersRepository implements IAnswersRepository {
    private final Map<UUID, Answer> answerMap = new HashMap<>();

    @Override
    public List<Answer> getAll() {
        return new ArrayList<>(answerMap.values());
    }

    @Override
    public Answer findById(UUID id) {
        return answerMap.get(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerMap.put(answer.getId(), answer);
    }
}
