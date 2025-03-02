package it.sevenbits.courses.springbootexample.core.service.questionsets;

import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.List;
import java.util.UUID;

public interface IQuestionSetsService {
    List<QuestionSet> getAll();
    QuestionSet findById(UUID id);
    QuestionSet save(QuestionSet question);
}
