package it.sevenbits.courses.springbootexample.core.service.answers;


import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;

import java.util.List;
import java.util.UUID;

public class AnswersService implements IAnswersService {
    private final IAnswersRepository answersRepository;

    public AnswersService(IAnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public List<Answer> getAll() {
        return answersRepository.getAll();
    }

    @Override
    public Answer findById(UUID id) {
        return answersRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answersRepository.save(answer);
    }
}
