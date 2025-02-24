package it.sevenbits.courses.springbootexample.core.repository.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

public interface IAnswersRepository {
    List<Answer> getAll();
    Answer findById(UUID id);
    Answer save(Answer answer);
}
