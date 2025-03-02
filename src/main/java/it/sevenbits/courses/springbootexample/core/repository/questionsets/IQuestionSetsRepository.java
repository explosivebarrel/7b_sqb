package it.sevenbits.courses.springbootexample.core.repository.questionsets;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.List;
import java.util.UUID;

public interface IQuestionSetsRepository {
    List<QuestionSet> getAll();
    QuestionSet findById(UUID id);
    QuestionSet save(QuestionSet question);
}
