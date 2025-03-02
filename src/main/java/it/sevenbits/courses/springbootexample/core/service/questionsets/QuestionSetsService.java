package it.sevenbits.courses.springbootexample.core.service.questionsets;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;

import java.util.List;
import java.util.UUID;

public class QuestionSetsService implements IQuestionSetsService {
    private final IQuestionSetsRepository questionSetsRepository;

    public QuestionSetsService(IQuestionSetsRepository questionSetsRepository) {
        this.questionSetsRepository = questionSetsRepository;
    }

    @Override
    public List<QuestionSet> getAll() {
        return questionSetsRepository.getAll();
    }

    @Override
    public QuestionSet findById(UUID id) {
        return questionSetsRepository.findById(id);
    }

    @Override
    public QuestionSet save(QuestionSet question) {
        return questionSetsRepository.save(question);
    }
}
