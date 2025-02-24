package it.sevenbits.courses.springbootexample.core.service.answers;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

public interface IAnswersService {
    List<Answer> getAll();
    Answer findById(UUID id);
    Answer save(Answer answer);
}
