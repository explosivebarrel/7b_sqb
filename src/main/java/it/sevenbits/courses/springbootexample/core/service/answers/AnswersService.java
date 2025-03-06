package it.sevenbits.courses.springbootexample.core.service.answers;


import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class AnswersService implements IAnswersService {
    private final IAnswersRepository answersRepository;

    /**
     *
     * @param answersRepository ar
     */
    public AnswersService(final IAnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    /**
     *
     * @return rt
     */
    @Override
    public List<Answer> getAll() {
        return answersRepository.getAll();
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Answer findById(final UUID id) {
        return answersRepository.findById(id);
    }

    /**
     *
     * @param answer a
     * @return rt
     */
    @Override
    public Answer save(final Answer answer) {
        return answersRepository.save(answer);
    }
}
