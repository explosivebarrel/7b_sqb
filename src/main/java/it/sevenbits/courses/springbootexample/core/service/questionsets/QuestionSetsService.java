package it.sevenbits.courses.springbootexample.core.service.questionsets;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class QuestionSetsService implements IQuestionSetsService {
    private final IQuestionSetsRepository questionSetsRepository;

    /**
     *
     * @param questionSetsRepository qsr
     */
    public QuestionSetsService(final IQuestionSetsRepository questionSetsRepository) {
        this.questionSetsRepository = questionSetsRepository;
    }

    /**
     *
     * @return rt
     */
    @Override
    public List<QuestionSet> getAll() {
        return questionSetsRepository.getAll();
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public QuestionSet findById(final UUID id) {
        return questionSetsRepository.findById(id);
    }

    /**
     *
     * @param question qs
     * @return rt
     */
    @Override
    public QuestionSet save(final QuestionSet question) {
        return questionSetsRepository.save(question);
    }
}
