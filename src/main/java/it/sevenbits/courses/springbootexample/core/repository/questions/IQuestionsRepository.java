package it.sevenbits.courses.springbootexample.core.repository.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;

import java.util.List;
import java.util.UUID;

public interface IQuestionsRepository {
    List<Question> getAll();
    List<Question> findByCategory(Category category);
    List<Question> findByText(String content); //Regex search in general
    Question findById(UUID id);
    Question save(Question question);
}
